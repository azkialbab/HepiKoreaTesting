Feature: Shipping Payment
  Pengujian fitur Shipping Payment oleh user
  yang digunakan untuk membayar pengiriman produk

  Background:
    Given user membuka platform HepiKorea

  Scenario: Membayar Pengiriman melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Sent
    And user mengklik tombol Pay shippment
    And user memilih metode pembayaran
    And user memilih tombol pay
    Then user diarahkan ke dalam halaman pembayaran

  Scenario: Gagal Membayar Pengiriman melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Sent
    Then user tidak menemukan pesanan yang ingin dibayar