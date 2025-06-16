Feature: Menambahkan Produk Baru sebagai Admin
  Pengujian kemampuan admin untuk menambahkan produk ke dalam platform HepiKorea.

  Background:
    Given user membuka platform HepiKorea
    And user login sebagai admin

  Scenario Outline: Admin menambahkan produk baru
    When admin klik tab produk
    And admin klik tombol add produk
    And admin mengisi nama produk dengan "<NamaProduk>"
    And admin mengisi harga produk dengan "<HargaProduk>"
    And admin memilih kategori produk "<KategoriProduk>"
    And admin mengisi deskripsi produk "<DeskripsiProduk>"
    And admin mengklik tombol Simpan
    Then muncul pesan "<ExpectedMessage>"

    Examples:
      | NamaProduk        | HargaProduk | KategoriProduk | DeskripsiProduk        | ExpectedMessage                         |
      | Kemeja Flanel     | 150000      | Fashion        | Berbahan kulit asli     | Successfully Added                      |
      | Sepatu Sneaker    | 250000      | Fashion        | Cocok untuk harian      | Successfully Added                      |
      | Botol Minum       | 50000       | Merchandise      | Plastik BPA Free        | Successfully Added                      |
      |                   | 150000      | Fashion        |                          | please fill out this field             |
      | Jaket Hoodie      |             | Fashion        |                          | please fill out this field             |
      | Dompet Kulit      | 120000      |                |   | please fill out this field             |
