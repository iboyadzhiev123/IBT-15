#A feature file with "Numeric Expressions" test examples from third Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com

Feature: "Numeric Expressions" test example (with Data Table) from third Cucumber story.
  Test scenarios illustrating the usage of Numeric expressions

  Rule: "Sum" tests with numeric expressions and Data Table

    @testExpressionsSumDataTable
    Scenario: Numeric scenario with Data Table and sum
      Given I have the following columns with numbers and I'd like to find the sum for each column and to compare them
        | 10   | 18   |
        | 23.7 | 21.4 |
        | 4    | 5    |
        | 12.5 | 17.9 |

  Rule: "Difference" tests with numeric expressions and Data Table

    @testExpressionsDiffDataTable
    Scenario: Numeric scenario with Data Table and difference
      Given I have the following columns with numbers and I'd like to find the difference for each column and to compare them
        | 10   | 18   |
        | 23.7 | 21.4 |
        | 4    | 5    |
        | 12.5 | 17.9 |