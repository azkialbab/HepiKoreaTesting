Feature: Sent Product
  Pengujian fitur Shipping Payment oleh user
  yang digunakan untuk membayar pengiriman produk

  Background:
    Given user membuka platform HepiKorea
    And user telah login sebagai admin

  Scenario: Mengirimkan produk kepada customer
    Given user berada di dashboard admin
    When user memilih tab Order pada side bar
    And user memilih section Order pada halaman order management
    Then user akan diarahkan ke dalam section order
    And user memilih salah satu pesanan
    And user mengklik tombol Process
    And user memasukan tanggal estimasi kedatangan produk di Indonesia
    Then status pesanan dalam riwayat pemesanan akan berubah menjadi process
    And user memilih tombol sent
    And user memasukan perusahaan ekspedisi
    And user memasuka harga pengiriman
    And user memasukkan kode resi
    And user memasukan tanggal estimasi kedatangan produk ke alamat customer
    Then status pesanan dalam riwayat pemesanan akan berubah menjadi sent

  Scenario: Tidak bisa mengirimkan produk kepada customer karena tidak ada pesanan
    Given user berada di dashboard admin
    When user memilih tab Order pada side bar
    And user memilih section Order pada halaman order management
    Then user akan diarahkan ke dalam section order tetapi tidak ada pesanan yang ditampilkan