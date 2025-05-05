Feature: Create account

  Scenario: User create an account
    Given User navigate to home page for sign up
    When User clicks on Sign up button in home page
    And User create credentials
    And User clicks on Sign up button in signUp page
    Then User sees the Sign up success message
    And User close the alert box