Feature: "Numeric Expressions" with Integers from third Cucumber story.
  Test scenarios illustrating the usage of Numeric expressions with Integer

  Rule: "Sum" tests with numeric expressions
    Background:
      Given I set the calculator type to sum

    @testNumericInteger
    Scenario Outline: a simple scenario with integers for sum
      Given the first int value is <input1>
      And the second int value is <input2>
      Then I expect the int result to be <expected>
      Examples:
        | input1 | input2 | expected |
        | 3      | 5      | 8        |
        | 10     | 6      | 16       |

    @testNumericIntegerDataTable
    Scenario: Numeric scenario with Data Table and sum
      Given I have the following columns with integers to sum
        | 10 | 18 |
        | 4  | 5  |
      And I'd like to find out which integer column has a bigger calculation

  Rule: "Diff" tests with numeric expressions
    Background:
      Given I set the calculator type to difference

    @testNumericInteger
    Scenario Outline: a simple scenario with integers for difference
      Given the first int value is <input1>
      And the second int value is <input2>
      Then I expect the int result to be <expected>
      Examples:
        | input1 | input2 | expected |
        | 3      | 5      | -2       |
        | 10     | 6      | 4        |

    @testNumericIntegerDataTable
    Scenario: Numeric scenario with Data Table and difference
      Given I have the following columns with integers to subtract
        | 10 | 18 |
        | 4  | 5  |
      And I'd like to find out which integer column has a bigger calculation
