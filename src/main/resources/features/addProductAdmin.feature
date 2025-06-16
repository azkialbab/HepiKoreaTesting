Feature: Menambahkan Produk Baru sebagai Admin
  Pengujian kemampuan admin untuk menambahkan produk ke dalam platform HepiKorea.

  Background:
    Given user membuka platform HepiKorea
    And user login sebagai admin

  Scenario Outline: Admin menambahkan produk baru dengan berbagai variasi data
    When admin klik tab produk
    And admin klik tombol add produk
    And admin mengisi nama produk dengan "<NamaProduk>"
    And admin mengisi harga produk dengan "<HargaProduk>"
    And admin memilih kategori produk "<KategoriProduk>"
    And admin mengisi deskripsi produk "<DeskripsiProduk>"
    And admin mengklik tombol Simpan
    Then <ExpectedResult>

    Examples:
      | NamaProduk        | HargaProduk | KategoriProduk | DeskripsiProduk        | ExpectedResult                                                           |
      | Kemeja Flanel     | 150000      | Fashion        | Berbahan kulit asli     | produk "Kemeja Flanel" muncul dalam daftar produk                        |
      | Sepatu Sneaker    | 250000      | Fashion        | Cocok untuk harian      | produk "Sepatu Sneaker" muncul dalam daftar produk                       |
      | Botol Minum       | 50000       | Aksesoris      | Plastik BPA Free        | produk "Botol Minum" muncul dalam daftar produk                          |
      | Handphone Gaming  | 3500000     | Elektronik     | RAM 8GB, 128GB Storage  | produk "Handphone Gaming" muncul dalam daftar produk                     |
      |                   | 150000      | Fashion        |   | muncul pesan kesalahan "Please fill out this field."                         |
      | Jaket Hoodie      |             | Fashion        |       | muncul pesan kesalahan "Please fill out this field."                        |
      | Dompet Kulit      | 120000      |                | Kategori belum dipilih  | muncul pesan kesalahan "Please fill out this field."                  |
