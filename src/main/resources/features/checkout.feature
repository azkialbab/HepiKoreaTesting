<<<<<<< HEAD
Feature: Checkout Produk
  Pengujian fitur checkout oleh customer pada platform HepiKorea.
=======
<<<<<<< HEAD
Feature: Checkout Produk
=======
Feature: Checkout
  Pengujian fitur Checkout oleh user
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master

  Background:
    Given user membuka platform HepiKorea
    And user telah melakukan login sebagai customer
<<<<<<< HEAD
    And user berada di halaman homepage setelah login

  Scenario: Berhasil melakukan checkout produk dari halaman Cart
=======
<<<<<<< HEAD
    And user berada di halaman utama setelah login

  Scenario: melakukan checkout produk dari cart
=======

  Scenario: melakukan checkout produk dari cart
    Given user berada di Halaman Homepage
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
>>>>>>> origin/master
    When user memilih tab Cart pada navigation bar
    Then user diarahkan ke halaman Cart
    And user memilih produk yang ingin dibayar
    And user mengklik tombol Checkout
    Then user diarahkan ke halaman Checkout
    And user memilih alamat pengiriman
    And user memilih jumlah produk di halaman Checkout
    And user mengklik tombol Checkout untuk melanjutkan
    And user memilih metode pembayaran
    And user mengklik tombol Pay
    Then user diarahkan ke halaman Pembayaran

<<<<<<< HEAD
  Scenario: Berhasil melakukan checkout produk dari halaman Detail Produk
    When user memilih produk bernama "Uniqlo" dari homepage
=======
<<<<<<< HEAD

=======
>>>>>>> 8e31d4374b7e76e4acea775f0ed31294b99ee066
  Scenario: melakukan checkout produk dari halaman produk detail
    Given user berada di halaman homepage
    When user memilih produk "Uniqlo" dari homepage
>>>>>>> origin/master
    And user mengklik tombol Buy
    Then user diarahkan ke halaman Detail Produk
    And user memilih jumlah produk di halaman Detail Produk
    And user mengklik tombol Buy Now
    Then user diarahkan ke halaman Checkout
    And user memilih alamat pengiriman
    And user memilih jumlah produk di halaman Checkout
    And user mengklik tombol Checkout untuk melanjutkan
    And user memilih metode pembayaran
    And user mengklik tombol Pay
    Then user diarahkan ke halaman Pembayaran

  Scenario: Gagal melakukan checkout dari halaman Cart karena sistem error
    When user memilih tab Cart pada navigation bar
    Then user diarahkan ke halaman Cart
    And user memilih produk yang ingin dibayar
    And user mengklik tombol Checkout
    Then sistem tidak mengarahkan user ke halaman Checkout
