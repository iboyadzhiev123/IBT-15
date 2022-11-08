#A feature file with "Text Expressions" test examples from fourth Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com
@testTextExpressionsAndRegEx
Feature: "Text Expressions" test examples from fourth and fifth Cucumber story.
  Test scenarios illustrating the usage of Text expressions + Regular expressions

  Background:
    Given I read the configuration

  @words
  Rule: Extend word tests with RegEx

  @testTextExpressionsWords
  Scenario: Compare words when first occurrence of any capital or small letter is removed
    Given the first word is CucumberaazzAAZZ
    And first occurrence of a is removed
    And first occurrence of z is removed
    And first occurrence of A is removed
    And first occurrence of Z is removed
    When the second word is cucumberazAZ
    Then I verify that the words are equal

  @testTextExpressionsWords
  Scenario: Compare words when all occurrences of any digit are removed
    Given the first word is Cucumber112233445566778899
    And all occurrences of 0 are removed
    And all occurrences of 1 are removed
    And all occurrences of 2 are removed
    And all occurrences of 3 are removed
    And all occurrences of 4 are removed
    And all occurrences of 5 are removed
    And all occurrences of 6 are removed
    And all occurrences of 7 are removed
    And all occurrences of 8 are removed
    And all occurrences of 9 are removed
    When the second word is cucumber
    Then I verify that the words are equal

  @sentences
  Rule: Extend sentences tests with RegEx

  @testTextExpressionsSentences
  Scenario: Compare sentences when first occurrence of ()[]{}: is removed
    Given the first sentence is "Cucumber is amazing()[]{}:()[]{}:"
    And first occurrence of ( is removed from a sentence
    And first occurrence of ) is removed from a sentence
    And first occurrence of [ is removed from a sentence
    And first occurrence of ] is removed from a sentence
    And first occurrence of { is removed from a sentence
    And first occurrence of } is removed from a sentence
    And first occurrence of : is removed from a sentence
    When the second sentence is "cucumber is amazing()[]{}:"
    Then I verify that the sentences are equal

  @testTextExpressionsSentences
  Scenario: Compare sentences when all occurrence of .?!;,-' are removed
    Given the first sentence is "Cucumber is amazing.?!;,-'.?!;,-'"
    And all occurrences of . are removed from a sentence
    And all occurrences of ? are removed from a sentence
    And all occurrences of ! are removed from a sentence
    And all occurrences of ; are removed from a sentence
    And all occurrences of , are removed from a sentence
    And all occurrences of - are removed from a sentence
    And all occurrences of ' are removed from a sentence
    When the second sentence is "cucumber is amazing"
    Then I verify that the sentences are equal

  Rule: Extend word and char count tests with RegEx

    Background:
      Given I pass the following paragraph :
      """
          Lorem ipsum dolor sit amet  ,   consectetur adipiscing elit  , sed do    eiusmod tempor incididunt ut labore et    dolore magna aliqua .
          Ut enim ad minim veniam ? Quis nostrud exercitation  ullamco laboris nisi ut aliquip ex ea commodo consequat .


          Duis aute irure dolor in reprehenderit in  voluptate  -  velit esse   cillum   dolore eu fugiat nulla pariatur ?
          Excepteur sint  occaecat cupidatat non  proident, sunt in culpa qui officia deserunt mollit anim id est laborum !
      """

    @testTextExpressionsWordCount
    Scenario: Verify the count of words in a text
      When all whitespaces before , are removed
      And all whitespaces before . are removed
      And all whitespaces before - are removed
      And all whitespaces before ? are removed
      And all whitespaces before ! are removed
      And all consecutive whitespace chars are replaced with a single space
      When I get the word count
      Then I verify the count is equal to 70

    @testTextExpressionsCharCount
    Scenario: Verify the count of chars in a text
      When all whitespaces before , are removed
      And all whitespaces before . are removed
      And all whitespaces before - are removed
      And all whitespaces before ? are removed
      And all whitespaces before ! are removed
      And all consecutive whitespace chars are replaced with a single space
      When I get the char count
      Then I verify the count is equal to 447