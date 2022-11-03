#A feature file with "Text Expressions" test examples from fourth Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com
@testTextExpressions
Feature: "Text Expressions" test examples from fourth Cucumber story.
  Test scenarios illustrating the usage of Text expressions

  Background:
    Given I read the configuration

  @testTextExpressionsWords
  Scenario: Test scenario with "Text Expressions" and comparing words
    Given The first word is "Cucumber"
    When The second word is "cucumber"
    Then I verify that the words are equal

  @testTextExpressionsSentences
  Scenario: Test scenario with "Text Expressions" and comparing sentences
    Given The first sentence is "Cucumber is amazing!"
    When The second sentence is "cucumber is amazing!"
    Then I verify that the sentences are equal

  @testTextExpressionsWordCount
  Scenario: Test scenario with "Text Expressions" and word count in a sentence
    Given I pass the following text:
    """
    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt
    ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis
    nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis
    aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
    Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim
    id est laborum.
    """
    When I get the word count
    Then I verify the count is equal to 70

  @testTextExpressionsCharCount
  Scenario: Test scenario with "Text Expressions" and char count in a sentence
    Given I pass the following text:
    """
    Not really my cup of tea
    """
    When I get the char count
    Then I verify the count is equal to 24