Feature: User Email Login
  Pengujian fitur login oleh user menggunakan email/password

  Background:
    Given user membuka halaman login dengan URL langsung

  Scenario Outline: Login dengan berbagai kombinasi email dan password
    When user memasukan email login "<Email>"
    And user memasukan password login "<Password>"
    And user mengklik tombol login di dalam halaman login
    Then user mendapatkan respon login "<Expected_result>"

    Examples:
      | Email                 | Password     | Expected_result                        |
      | testuser@example.com  | testpassword | user diarahkan ke dalam halaman homepage |
      | wrong@example.com     | salah123     | Email is not registered.               |
      |                       | test123      | Please fill out this field.            |
      | customer@example.com  |             | Please fill out this field.            |
