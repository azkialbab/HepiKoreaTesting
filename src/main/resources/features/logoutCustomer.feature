Feature: Customer Logout
  Pengujian fitur logout oleh customer

  Background:
    Given user membuka platform HepiKorea
    And user telah berhasil login sebagai customer

  Scenario:
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab Logout pada dropdown Profile
    And user memilih tombol confirm
    Then user akan kembali ke homepage dan menampilkan tombol login pada navigation bar

  Scenario: Batal melakikan logout
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab Logout pada dropdown Profile
    And user memilih tombol cancel
    Then user tetap berada di homepage dan menampilkan profile picture pada navigation bar