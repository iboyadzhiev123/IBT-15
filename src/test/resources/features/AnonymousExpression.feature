#A feature file with "Expressions" test examples from second Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com

Feature: Anonymous expressions scenario from second Training story "IBT-17"

  Rule: Very basic scenarios that illustrate the different types of data sent as parameters for the steps

    @testExpressions
    Scenario: Anonymous expressions scenario with different basic types
      #first test with expressions
      Given I am at the registration form
      And I am thinking about the following:
      """
      Make a mental note to write this down before leaving today
      """
      When I insert "John Kirilov" name
      * I insert 40.5 years of age
      Then I set my lucky number as 10
      And I choose Applepie as my secret
      But I insert "john65@yahoo.com" as e-mail address

    @testExpressions
    Scenario: Negative scenario
      #second test with expressions
      Given I am not at the registration form
      Then I don't wanna be bothered

    @testExpressions
    Scenario Outline: examples demo with several simple steps
      #exaample of an outline
      Given the person's name is "<name>"
      Then the person's nationality is "<nationality>"
      And the person's age is "<age>"

      Examples:
        | name              | nationality | age |
        | Sasho Alexandrov  | Bulgarian   | 45  |
        | Trevor White      | American    | 52  |
        | Maximiliana Hanke | German      | 36  |