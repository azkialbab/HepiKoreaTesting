Feature: Checkout Produk

  Background:
    Given user membuka platform HepiKorea
    And user telah melakukan login sebagai customer
    And user berada di halaman utama setelah login

  Scenario: melakukan checkout produk dari cart
    When user memilih tab Cart pada navigation bar
    Then user akan diarahkan ke dalam halaman keranjang
    And user memilih produk yang ingin di bayar
    And user mengklik tombol Checkout
    Then user akan diarahkan ke dalam halaman checkout
    And user memilih alamat pengiriman
    And user memilih jumlah produk
    And user memilih tombol checkout
    And user memilih metode pembayaran
    And user memilih tombol pay
    Then user diarahkan ke dalam halaman pembayaran


  Scenario: melakukan checkout produk dari halaman produk detail
    Given user berada di halaman homepage
    When user memilih produk "Uniqlo" dari homepage
    And user mengklik tombol Buy
    Then user akan diarahkan ke dalam halaman product detail
    And user memilih jumlah product di halaman product detail
    And user mengklik tombol Buy Now
    Then user akan diarahkan ke dalam halaman checkout
    And user memilih alamat pengiriman
    And user memilih jumlah produk
    And user memilih tombol checkout
    And user memilih metode pembayaran
    And user memilih tombol pay
    Then user diarahkan ke dalam halaman pembayaran

  Scenario: Gagal melakukan checkout produk dari cart
    Given user berada di homepage
    When user memilih tab Cart pada navigation bar
    Then user akan diarahkan ke dalam halaman keranjang
    And user memilih produk yang ingin di bayar
    And user mengklik tombol Checkout
    Then sistem tidak mengarahkan user ke dalam halaman checkout