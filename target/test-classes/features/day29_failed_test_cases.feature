@failed_test_case
Feature: customer_login
  Scenario Outline: TC01_<PositiveTest>_customer_login_test
    Given user_navigates to "https://www.bluerentalcars.com/"
    And user clicks on home page login button
    And enter "<email>" and "<password>"
    Then user logs out the application
    Then close the application
    Examples: test_data
      | email                          | password  |
      | sam.walker@bluerentalcars.com  | c!fas_art |
      | kate.brown@bluerentalcars.com  | tad1$Fas  |