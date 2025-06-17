Feature: Finish order
  Pengujian fitur konfirmasi pesanan telah diterima oleh user

  Background:
    Given user telah melakukan login sebagai customers

  Scenario: User mengkonfirmasi pesanan telah diterima
    When user membuka halaman sent
    Then user mengklik confirm arrival pada order yang sudah dikirim
