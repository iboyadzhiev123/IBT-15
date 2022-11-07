#A feature file with "RegEx" test examples from fifth Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com

@RegEx
Feature: Extending StringHelper tests with RegEx steps

  Background:
    Given I read the configuration

  @words
  Rule: Extend word tests with RegEx

  Scenario: Compare words when first occurrence of any capital or small letter is removed
    #Given the first word is "CucumberaazzAAZZ"
    Given the first word is CucumberaazzAAZZ
    And first occurrence of a is removed
    And first occurrence of z is removed
    And first occurrence of A is removed
    And first occurrence of Z is removed
    When the second word is cucumberazAZ
    Then we verify that the words are equal

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
    Then we verify that the words are equal

  @sentences
  Rule: Extend sentences tests with RegEx

  Scenario: Compare sentences when first occurrence of ()[]{}: is removed
    Given first sentence is "Cucumber is amazing()[]{}:()[]{}:"
    And first occurrence of ( is removed from a sentence
    And first occurrence of ) is removed from a sentence
    And first occurrence of [ is removed from a sentence
    And first occurrence of ] is removed from a sentence
    And first occurrence of { is removed from a sentence
    And first occurrence of } is removed from a sentence
    And first occurrence of : is removed from a sentence
    When second sentence is "cucumber is amazing()[]{}:"
    Then we verify that the sentences are equal

  Scenario: Compare sentences when all occurrence of .?!;,-' are removed
    Given first sentence is "Cucumber is amazing.?!;,-'.?!;,-'"
    And all occurrences of . are removed from a sentence
    And all occurrences of ? are removed from a sentence
    And all occurrences of ! are removed from a sentence
    And all occurrences of ; are removed from a sentence
    And all occurrences of , are removed from a sentence
    And all occurrences of - are removed from a sentence
    And all occurrences of ' are removed from a sentence
    When second sentence is "cucumber is amazing"
    Then we verify that the sentences are equal