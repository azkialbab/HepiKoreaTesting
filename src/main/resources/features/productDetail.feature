Feature: Product Detail
  Pengujian fitur Product Detail oleh user

  Background:
    Given user berada di halaman homepage untuk produk

  Scenario: Menambahkan produk yang valid dari homepage
    When user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk
    And user mengklik tombol Add to Cart
    Then produk disimpan dan ditampilkan di cart

  Scenario: Menambahkan produk yang valid dari halaman product
    When user membuka tab Product dari navbar
    Then user masuk ke halaman daftar produk
    And user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk
    And user mengklik tombol Add to Cart
    Then produk disimpan dan ditampilkan di cart

  Scenario: Melihat detail produk yang tidak ada dari homepage
    When user memilih produk bernama "Rolex"
    And user mengklik tombol Buy Produk
    Then produk tidak ditemukan di halaman product detail

  Scenario: Melihat detail produk yang tidak ada dari halaman product
    When pengguna klik tab Product dari navbar
    And user memilih produk bernama "Rolex"
    And user mengklik tombol Buy Produk
    Then produk tidak ditemukan di halaman product detail

  Scenario: Gagal menambahkan produk karena keranjang penuh dari homepage
    When user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user akan diarahkan ke halaman product detail
<<<<<<< HEAD
    And user memilih jumlah produk di halaman detail
=======
    And user memilih jumlah produk
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
    And user mengklik tombol Add to Cart
    Then produk gagal ditambahkan ke cart

  Scenario: Gagal menambahkan produk karena keranjang penuh dari halaman product
    When user membuka tab Product dari navbar
    Then user masuk ke halaman daftar produk
    And user memilih produk bernama "Uniqlo"
    And user mengklik tombol Buy Produk
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk
    And user mengklik tombol Add to Cart
    Then produk gagal ditambahkan ke cart
