Feature: Admin Login
  Pengujian fitur login oleh admin menggunakan email/password

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
      | admin@admin.com           | 123             | user diarahkan ke dalam halaman dashboard admin               |
      | failed_admin@admin.com    | 123             | user mendapatkan pesan error "email not found"                |
      | ""                        | 123             | user mendapatkan pesan error "email tidak boleh kosong"       |
      | admin@admin.com           | ""              | user mendapatkan pesan error "password tidak boleh kosong"    |
