Feature: User Google Login
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
  Pengujian fitur login oleh user dan admin menggunakan Google Account

  Background:
    Given user berada di halaman login untuk Google

  Scenario Outline: Login menggunakan Google Account
<<<<<<< HEAD
    Given user berada di halaman login Google
=======
=======
  Pengujian fitur login oleh user dan admin menggunakan google account

  Background:
    Given user membuka platform HepiKorea
    When user mengklik tombol login di halaman homepage untuk login
    Then user diarahkan ke halaman login melalui Google

  Scenario Outline: Login menggunakan Google Account
    Given user berada di halaman login Google
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    When user klik tombol Google Sign-In
    And user pilih akun Google "<Google Account>"
    And user konfirmasi login Google
    Then user mendapatkan respon login Google "<Expected_result>"

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> origin/master
    Examples:
      | Google Account            | Expected_result                                                  |
      | azkialbab84@gmail.com     | user diarahkan ke dalam halaman homepage                         |
      | failed@gmail.com          | user tidak pergi dari halaman login karena gmail tidak ditemukan |
<<<<<<< HEAD
=======
=======

    Examples:
      | Google Account            | Expected_result                                                      |
      | heinrichraditya@gmail.com | user diarahkan ke dalam halaman homepage                             |
      | failed@gmail.com          | user tidak pergi dari halaman login karena gmail tidak ditemukan     |
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
