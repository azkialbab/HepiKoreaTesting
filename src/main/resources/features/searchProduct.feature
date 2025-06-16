Feature: Product Search
  Pengujian fitur Searcg oleh user
  Pengguna dapat mencari produk spesifik menggunakan Searchbar

  Background:
    Given pengguna membuka platform HepiKorea

  Scenario Outline: mencari produk menggunakan valid keyword
    Given user berada di homepage
    When pengguna memilih tab Produk melalui homepage
    And user memilih searchbar
    And user memasukan kata kunci produk "<Keyword>"
    And user mengklik tombol Search
    Then sistem menampilkan hasil pencarian

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