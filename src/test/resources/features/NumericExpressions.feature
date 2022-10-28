#A feature file with "Numeric Expressions" test examples from third Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com

Feature: "Numeric Expressions" test examples from third Cucumber story.
  Test scenarios illustrating the usage of Numeric expressions

  Rule: "Sum" tests with examples that verifies the calculator's output

    @testExpressionsSum
    Scenario Outline: a simple scenario
      Given I want to find the sum of <input1> and <input2>
      Then I'd like to verify that the expected result is <expected>
      Examples:
        | input1 | input2 | expected |
        | 3      | 5      | 8        |
        | 1.2    | 3.0    | 4.2      |


  Rule: "Difference" tests with examples that verifies the calculator's output

    @testExpressionsDiff
    Scenario Outline: a simple scenario
      Given I want to find the difference of <input1> and <input2>
      Then I'd like to verify that the expected result is <expected>
      Examples:
        | input1 | input2 | expected |
        | 10     | 6      | 4        |
        | 7.5    | 2.5    | 5        |

    Scenario: Try
      Given I want to find the sum of 3 and 5
      Then I'd like to verify that the expected result is 8