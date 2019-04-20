Feature: Negative login scenarios

@Regression
@Sanity
  Scenario Outline: Negative test with both incorrect
    Given I have wordpress site
    When I provide incorrect <user> and <pass>
    Then check the <expectedError> message

    Examples: 
      | user   | pass      | expectedError                                                                            |
      | saurab | saurab123 | ERROR: Invalid username. Lost your password?                                             |
      | saurab | demo123   | ERROR: Invalid username. Lost your password?                                             |
      | admin  | saurab123 | ERROR: The password you entered for the username admin is incorrect. Lost your password? |
