Feature: Product Detail
  Pengujian fitur halaman detail produk oleh user pada platform HepiKorea.

  Background:
    Given user berada di halaman homepage

  Scenario: Berhasil menambahkan produk dari homepage
    When user memilih produk bernama "Uniqlo" dari homepage
    And user mengklik tombol Buy Produk
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
<<<<<<< HEAD
    Then user diarahkan ke halaman Detail Produk
    And user memilih jumlah produk melebihi kapasitas keranjang
=======
    Then user akan diarahkan ke halaman product detail
<<<<<<< HEAD
    And user memilih jumlah produk di halaman detail
=======
    And user memilih jumlah produk
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
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
