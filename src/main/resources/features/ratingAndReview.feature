Feature: Rating and Review
  Pengujian fitur Rating dan Review oleh user
  yang digunakan untuk memberikan review terhadap produk yang telah dipesan

  Background:
    Given user membuka platform HepiKorea

  Scenario: Menilai produk menggunakan Rating dan Review melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    And user mengklik tombol Finish
    And user memilih rating produk
    And user menulis review produk
    And user mengklik tombol Submit
    Then rating dan review akan ditampilkan dalam produk detail produk tersebut

  Scenario: Gagal Menilai produk karena tidak ada produk yang dipesan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    Then tidak ada pesanan yang ditampilkan

  Scenario: Gagal menilai produk tanpa memberikan Rating melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    And user mengklik tombol Finish
    And user menulis review produk
    And user mengklik tombol Submit
    Then user akan mendapatkan pesan error "Rating tidak boleh kosone"

  Scenario: Gagal menilai produk tanpa memberikan  Rating melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    And user mengklik tombol Finish
    And user memilih rating produk
    And user mengklik tombol Submit
    Then user akan mendapatkan pesan error "Review tidak boleh kosong"