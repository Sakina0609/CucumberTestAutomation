Feature: Add a contact

  Background:
    Given User has already logged in to the application
      | userName                   | Password |
      | sakinajunkmail88@gmail.com | Pass%123 |


  Scenario Outline: Adding new contact information
    Given User clicks on the create button
    When User fills "<firstname>", "<lastname>", "<status>" and clicks on save button
    Then User clicks on save button
    And Verify that contact having "<firstname>", "<lastname>" details are saved successfully

    Examples:
      | firstname | lastname | status |
      | Courtney  | Cox      | New    |
      | Chandler  | Bing     | New    |

  Scenario Outline: Verify newly added contacts displayed on the Homepage
    Given User clicks on the home button
    Then Verify that Homepage appears
    And Verify that contact having "<firstname>", "<lastname>" details are displayed successfully

    Examples:
      | firstname | lastname |  |
      | Courtney  | Cox      |  |
      | Chandler  | Bing     |  |