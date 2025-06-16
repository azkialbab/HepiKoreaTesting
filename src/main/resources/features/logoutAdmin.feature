Feature: Admin Logout
  Pengujian fitur logout oleh admin

  Background:
    Given user membuka platform HepiKorea
    And user login sebagai admin

  Scenario: Berhasil melakukan logout
    Given user berada di dashboard admin
    When user memilih tombol logout
    Then user diarahkan ke homepage dan tombol login terlihat


#  Scenario: Batal melakukan logout
#    Given user berada di dashboard admin
#    When user memilih tombol logout
#    And user memilih tombol cancel dari logout
#    Then user akan tetap berada di halaman dashboard admin
