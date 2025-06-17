Feature: Admin Login
  Pengujian fitur login oleh admin menggunakan email dan password

  Background:
    Given user membuka platform HepiKorea
    And user berada di halaman login untuk admin

  Scenario Outline: Login menggunakan kombinasi email dan password
    When user memasukan email admin "<Email>"
    And user memasukan password admin "<Password>"
    And user mengklik tombol login untuk login admin
    Then user mendapatkan respon login admin "<Expected_result>"

    Examples:
      | Email                  | Password | Expected_result                                      |
      | admin@admin.com        | 123      | dashboard admin                                     |
      | failed_admin@admin.com | 123      | email is not registered                                      |
      |                        | 123      | please fill out this field                            |
      | admin@admin.com        |          | please fill out this field                        |
