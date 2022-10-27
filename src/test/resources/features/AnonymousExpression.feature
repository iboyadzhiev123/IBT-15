Feature: Anonymous expressions scenario
  A very basic scenario that illustrates the different types of data sent as parameters for the steps
  Scenario: Anonymous expressions scenario with different basic types
    Given I am at the registration form
    When I insert "John Kirilov" name
    And I insert 40.5 years of age
    Then I my lucky number is 10
    And I choose Applepie as my secret
    And I insert "john65@yahoo.com" as e-mail address

  Scenario: Negative scenario
    Given I am not at the registration form
    Then I don't wanna be bothered