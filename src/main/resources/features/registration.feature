Feature: User Registration
  Pengujian fitur registrasi oleh user


  Background:
    Given user membuka platform HepiKorea
    When user mengklik tombol login di halaman homepage
    Then user diarahkan ke dalam halaman login
    And user mengklik tombol Register
    Then user diarahkan ke dalam halaman registrasi

  Scenario Outline: Registrasi akun baru menggunakan fullname, email, password, dan confirmed password
    Given user berada di halaman registrasi
    When user memasukan fullname "<Fullname>"
    And user memasukan email "<Email>"
    And user memasukan password "<Password>"
    And user memasukan confirmed password "<Confirm Password>"
    And user mengklik tombol Register di dalam halaman Register
    And user memasukkan OTP yang dikirim via email
    Then user mendapatkan respon "<Expected_result>"

    Examples:
      |Fullname | Email                     | Password    |Confirm Password   | Expected_result                                                     |
      |customer | customer@example.com      | test123     | test123           | user diarahkan ke dalam halaman homepage                            |
      |customer | customer@example.com       | 1          | 1                 | user mendapatkan pesan error "password minimal 6 karakter"          |
      |""       | customer@example.com      | test123     | test123           | user mendapatkan pesan error "Fullname tidak boleh kosong"          |
      |customer | ""                        | test123     | test123           | user mendapatkan pesan error "email tidak boleh kosong"             |
      |customer | customer@example.com      | ""          | test123           | user mendapatkan pesan error "Password tidak boleh kosong"          |
      |customer | customer@example.com      | test123     | ""                | user mendapatkan pesan error "Confirm Password tidak boleh kosong"  |

