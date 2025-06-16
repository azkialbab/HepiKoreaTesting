Feature: User Google Login
  Pengujian fitur login oleh user dan admin menggunakan google account

  Background:
    Given user membuka platform HepiKorea
    When user mengklik tombol login di halaman homepage untuk login
    Then user diarahkan ke halaman login melalui Google

  Scenario Outline: Login menggunakan Google Account
    Given user berada di halaman login Google
    When user klik tombol Google Sign-In
    And user pilih akun Google "<Google Account>"
    And user konfirmasi login Google
    Then user mendapatkan respon login Google "<Expected_result>"


    Examples:
      | Google Account            | Expected_result                                                      |
      | heinrichraditya@gmail.com | user diarahkan ke dalam halaman homepage                             |
      | failed@gmail.com          | user tidak pergi dari halaman login karena gmail tidak ditemukan     |
