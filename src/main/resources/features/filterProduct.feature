Feature: Product Filter
  Pengujian fitur Filter oleh user
  Pengguna dapat mencari produk spesifik menggunakan filter

  Background:
    Given pengguna membuka platform HepiKorea

  Scenario Outline: Registrasi akun baru menggunakan fullname, email, password, dan confirmed password
    When pengguna memilih tab Product pada navigation bar
    And user memilih kategori "<Category>"
    And user memasukan minimum price "<Min Price>"
    And user memasukan maximum price "<Max Price>"
    And user memilih sort by "<Sort By>"
    Then sistem mengirimkan respon "<Expected Result>"

    Examples:
      | Category    | Min Price | Max Price | Sort By     | Expected Result     |
      | Fashion     | 100000    | 300000    | Most Order  | Produk Ditampilkan  |
      | Medicine    | 100000    | 300000    | Most Order  | Product Not Found   |
      | ""          | 100000    | 300000    | Most Order  | Produk not Found    |
      | Fashion     | ""        | 300000    | Most Order  | Produk Ditampilkan  |
      | Fashion     | 100000    | ""        | Most Order  | Produk Ditampilkan  |
      | Fashion     | 100000    | 300000    | ""          | Produk Ditampilkan  |

