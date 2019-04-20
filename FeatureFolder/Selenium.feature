
Feature: Feature to test Wordpress

@Regression
@Smoke
Scenario: Positive test
    Given I have wordpress site
    When I provide username and password
    Then I should see the dashboard


