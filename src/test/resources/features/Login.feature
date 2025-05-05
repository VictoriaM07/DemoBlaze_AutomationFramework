Feature: User login

  Scenario: User sign in with user credentials
    Given User navigate to home page for login
    When User clicks on Log in button in home page
    And User inputs "maria966" and password
    And User clicks on Log in button in login page
    Then User sees the Welcome message

  Scenario: User sign in with multiple usernames
    Given User navigate to home page for login
    When User clicks on Log in button in home page
    And User attemps to sign in with the following usernames:
      | maria966 |
      | maria117 |
      | alex563  |
