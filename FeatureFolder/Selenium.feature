@Saurab
Feature: Feature to test Wordpress

  Background: 
    Given I have wordpress site

  
  Scenario: Positive test
    When I provide username
    And I provide password
    Then I should see the dashboard


  Scenario Outline: Negative test with both incorrect
    When I provide incorrect <user> and <pass>
    Then check the <expectedError> message

    Examples: 
      | user   | pass      | expectedError                                |
      | saurab | saurab123 | ERROR: Invalid username. Lost your password? |
