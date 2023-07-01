@grid
Feature: grid_feature
  @grid_chrome
  Scenario: TC01_test_case_on_chrome
    Given user is on the "https://www.github.com" url on "chrome" browser
    Then verify the page title contains "GitHub" on grid
    Then close the remote driver
  @grid_firefox
  Scenario: TC02_test_case_on_firefox
    Given user is on the "https://www.github.com" url on "firefox" browser
    Then verify the page title contains "GitHub" on grid
    Then close the remote driver

