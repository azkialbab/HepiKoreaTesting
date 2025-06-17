Feature: Payment Shipment
  Pembayaran biaya pengiriman barang

  Background:
    Given user telah melakukan login sebagai customers
    And user membuka halaman sent

  Scenario: Pengguna dapat melakukan pembayaran biaya pengiriman barang
    When user mengklik pembayaran pengiriman
    Then user mengklik bayar pengiriman
    And user memilih metode pembayaran pengiriman
    Then payment modal muncul
