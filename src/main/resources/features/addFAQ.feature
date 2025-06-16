Feature: Menambahkan FAQ Baru sebagai Admin
  Pengujian kemampuan admin untuk menambahkan Frequently Asked Questions (FAQ) di platform HepiKorea.

  Background:
    Given user membuka platform HepiKorea
    And user login sebagai admin

  Scenario Outline: Admin menambahkan FAQ baru dengan berbagai variasi data
    When admin klik tab FAQ
    And admin klik tombol Add FAQ
    And admin mengisi FAQ Title dengan "<FAQTitle>"
    And admin mengisi FAQ Content dengan "<FAQContent>"
    And admin klik tombol Save
    Then <ExpectedResult>

    Examples:
      | FAQTitle                              | FAQContent                                                      | ExpectedResult                                                              |
      | Bagaimana cara retur produk?          | Hubungi CS maksimal 7 hari setelah produk diterima              | FAQ "Bagaimana cara retur produk?" muncul dalam daftar FAQ                  |
      | Apakah bisa COD (Cash on Delivery)?   | Saat ini kami belum menyediakan layanan COD.                    | FAQ "Apakah bisa COD (Cash on Delivery)?" muncul dalam daftar FAQ           |
      | Bagaimana cara melacak pesanan saya?  | Gunakan nomor resi dari email untuk cek melalui halaman tracking| FAQ "Bagaimana cara melacak pesanan saya?" muncul dalam daftar FAQ          |
      |                                       | Hubungi CS jika Anda mengalami kendala saat pembayaran.         | muncul pesan kesalahan "The question field is required."                       |
      | Bagaimana cara bayar lewat transfer?  |                                                                  | muncul pesan kesalahan "The answer field is required."                     |
