<<<<<<< HEAD
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
=======
Feature: User Email Login
  Pengujian fitur login oleh user menggunakan email/password

  Background:
    Given user membuka platform HepiKorea
    When user mengklik tombol login di halaman homepage
    Then user diarahkan ke dalam halaman login

  Scenario Outline: Login menggunakan kombinasi email dan password
    Given user berada di halaman login
    When user memasukan email "<Email>"
    And user memasukan password "<Password>"
    And user mengklik tombol login di dalam halaman login
    Then user mendapatkan respon "<Expected_result>"

    Examples:
      | Email                     | Password        | Expected_result                                               |
      | customer@example.com      | test123         | user diarahkan ke dalam halaman homepage                      |
      | wrong@hepikorea.com       | anypass         | user mendapatkan pesan error "email not found"                |
      | ""                        | correctpass123  | user mendapatkan pesan error "email tidak boleh kosong"       |
      | customer@example.com      | ""              | user mendapatkan pesan error "password tidak boleh kosong"    |
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
