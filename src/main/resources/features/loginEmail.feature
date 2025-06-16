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
