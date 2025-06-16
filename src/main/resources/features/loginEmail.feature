Feature: User Login
  Pengujian fitur login menggunakan email dan password

  Background:
    Given user membuka platform HepiKorea
    And user berada di halaman login

  Scenario Outline: Login dengan email dan password valid atau invalid
    When user memasukan email "<Email>"
    And user memasukan password "<Password>"
    And user mengklik tombol login di dalam halaman login
    Then user mendapatkan respon "<ExpectedResult>"

    Examples:
      | Email                 | Password     | ExpectedResult                        |
      | testuser@example.com  | testpassword | user diarahkan ke dalam halaman homepage |
      | wrong@example.com     | salah123     | Email is not registered.               |
      |                       | test123      | Please fill out this field.            |
      | customer@example.com  |             | Please fill out this field.            |
