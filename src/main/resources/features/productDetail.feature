Feature: Product Detail
  Pengujian fitur halaman detail produk oleh user pada platform HepiKorea.

  Background:
    Given user berada di halaman homepage

  Scenario: Menambahkan produk dari Best Seller ke Cart
    Given user berada di halaman homepage
    When user memilih produk dari best seller
    Then user diarahkan ke halaman Detail Produk
    And user memilih jumlah produk yang valid
    And user mengklik tombol Add to Cart
    Then produk disimpan dan ditampilkan di halaman Cart


  Scenario: Berhasil menambahkan produk dari halaman daftar produk
    When user membuka tab Product dari navbar
    Then user diarahkan ke halaman daftar produk
    And user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user diarahkan ke halaman Detail Produk
    And user memilih jumlah produk yang valid
    And user mengklik tombol Add to Cart
    Then produk disimpan dan ditampilkan di halaman Cart

  Scenario: Gagal melihat detail produk yang tidak tersedia dari homepage
    When user memilih produk bernama "Rolex" dari homepage
    And user mengklik tombol Buy Produk
    Then sistem menampilkan pesan error "Produk tidak ditemukan"

  Scenario: Gagal melihat detail produk yang tidak tersedia dari halaman daftar produk
    When user membuka tab Product dari navbar
    Then user diarahkan ke halaman daftar produk
    And user memilih produk bernama "Rolex"
    And user mengklik tombol Buy Produk
    Then sistem menampilkan pesan error "Produk tidak ditemukan"

  Scenario: Gagal menambahkan produk karena melebihi kapasitas keranjang dari homepage
    When user memilih produk bernama "Uniqlo" dari homepage
    And user mengklik tombol Buy Produk
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk di halaman detail
    And user mengklik tombol Add to Cart
    Then sistem menampilkan pesan error "Jumlah melebihi kapasitas keranjang"

  Scenario: Gagal menambahkan produk karena melebihi kapasitas keranjang dari halaman daftar produk
    When user membuka tab Product dari navbar
    Then user diarahkan ke halaman daftar produk
    And user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user diarahkan ke halaman Detail Produk
    And user memilih jumlah produk melebihi kapasitas keranjang
    And user mengklik tombol Add to Cart
    Then sistem menampilkan pesan error "Jumlah melebihi kapasitas keranjang"
