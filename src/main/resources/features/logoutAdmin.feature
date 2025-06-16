Feature: Admin Logout
  Pengujian fitur logout oleh admin

  Background:
    Given user membuka platform HepiKorea
    And user telah melakukan login sebagai admin

  Scenario: Berhasil melakikan logout
    Given user berada di dashboard admin
    When user memilih tombol Logout
    And user memilih tombol confirm logout
    Then user akan kembali ke halamab homepage dan menampilkan tombol login pada navigation bar

  Scenario: Batal melakikan logout
    Given user berada di dashboard admin
    When user memilih tombol Logout
    And user memilih tombol cancel dari logout
    Then user akan tetap berada di halaman dashboard admin