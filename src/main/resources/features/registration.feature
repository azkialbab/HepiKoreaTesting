Feature: User Registration
  Pengujian fitur registrasi oleh user

  Background:
    Given user berada di halaman login
    And user mengklik tombol Register
    Then user diarahkan ke dalam halaman registrasi

  Scenario Outline: Registrasi akun baru menggunakan fullname, email, password, dan confirmed password
    Given user berada di halaman registrasi
    When user memasukan fullname "<Fullname>"
    And user memasukan email register "<Email>"
    And user memasukan password register "<Password>"
    And user memasukan confirmed password "<Confirm Password>"
    And user mengklik tombol Register di dalam halaman Register
    And user memasukkan OTP yang dikirim via email
    Then user mendapatkan respon hasil registrasi "<Expected_result>"

    Examples:
      | Fullname | Email                | Password | Confirm Password | Expected_result                                                    |
      | customer | bismillah@example | test123  | test123          | Save Password                           |
      | customer | customer@example.com | 1        | 1                | The email has already been taken.         |
      |       | customer@example.com | test123  | test123          | please fill out this field         |
      | customer |                  | test123  | test123          | please fill out this field            |
      | customer | customer@example.com |       | test123          | please fill out this field         |
      | customer | customer@example.com | test123  |               | please fill out this field |
