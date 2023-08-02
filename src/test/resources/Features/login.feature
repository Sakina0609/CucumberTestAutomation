Feature: Free CRM login Feature

  Scenario: Login test Scenario
    Given User is on the login page
    When User enters "sakinajunkmail88@gmail.com" and "Pass%123"
    And Clicks on login button
    Then Verify that Homepage appears

  Scenario Outline: Login with invalid credentials
    Given User is on the login page
    When User enters invalid "<username>" and "<password>"
    And Clicks on login button
    Then "<Error>" message appears
    Examples:
      | username      | password | Error         |
      | roy@email.com | test@123 | Invalid login |




