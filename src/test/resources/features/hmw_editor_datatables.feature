@hmw_edit
Feature: creating a new user
  Scenario Outline: TC01_creating_new_user

    Given user_navigates to "https://editor.datatables.net/"
    And user clicks on the new button
    And user enter "<firstname>" and "<lastname>" and "<position>" and "<office>" and "<extention>" and "<startdate>" and "<salary>"
    And capture the screenshot
    And click create button
    And search for the "<firstname>"
    Then verify the name field contains "<firstname>"
    Then close the application
    Examples:
      | firstname | lastname | position | office | extention | startdate  | salary |
      | faruk     | ozacar   | qa       | malmo  | 123       | 2022-11-15 | 200000 |