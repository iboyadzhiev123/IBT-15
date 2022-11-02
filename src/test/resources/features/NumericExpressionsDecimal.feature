Feature: "Numeric Expressions" with Decimals from third Cucumber story.
  Test scenarios illustrating the usage of Numeric expressions with Decimal

  Rule: "Sum" tests with numeric expressions
    Background:
      Given I set the calculator type to sum

    @testNumericDecimal
    Scenario Outline: a simple scenario with decimals for sum
      Given the first dec value is <input1>
      And the second dec value is <input2>
      Then I expect the dec result to be <expected>
      Examples:
        | input1 | input2 | expected |
        | 1.2    | 3.0    | 4.2      |
        | 7.5    | 2.5    | 100      |

    @testNumericDecimalDataTable
    Scenario: Decimal scenario with Data Table and sum
      Given I have the following columns with decimals to sum
        | 10 | 18 |
        | 4  | 5  |
      And I'd like to find out which decimal column has a bigger calculation

  Rule: "Diff" tests with numeric expressions
    Background:
      Given I set the calculator type to difference

    @testNumericDecimal
    Scenario Outline: a simple scenario with decimals for difference
      Given the first dec value is <input1>
      And the second dec value is <input2>
      Then I expect the dec result to be <expected>
      Examples:
        | input1 | input2 | expected |
        | 1.2    | 3.0    | -1.8     |
        | 7.5    | 2.5    | 5        |

    @testNumericDecimalDataTable
    Scenario: Decimal scenario with Data Table and sum
      Given I have the following columns with decimals to subtract
        | 10.3 | 18  |
        | 4    | 5.6 |
      And I'd like to find out which decimal column has a bigger calculation