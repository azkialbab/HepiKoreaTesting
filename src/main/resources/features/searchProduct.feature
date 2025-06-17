Feature: Product Search
  Pengujian fitur Searcg oleh user
  Pengguna dapat mencari produk spesifik menggunakan Searchbar

  Background:
    Given pengguna membuka platform HepiKorea

  Scenario Outline: Cari produk dari halaman product
    Given user berada di halaman produk
    When user memilih searchbar di halaman produk
    And user memasukan kata kunci produk "Kemeja" di halaman produk
    And user mengklik tombol Search di halaman produk
    Then sistem menampilkan hasil pencarian produk


    Examples:
      |Keyword  |
      |Uniqlo   |
      |Zara     |
      |Shirt    |
      |""       |

  Scenario: mencari produk yang tidak ada
    Given user berada di homepage
    When pengguna memilih tab Product pada navigation bar
    And user memilih searchbar
    And user memasukan kata kunci produk "Rolex"
    And user mengklik tombol Search
    Then sistem tidak menampilkan produk apapun