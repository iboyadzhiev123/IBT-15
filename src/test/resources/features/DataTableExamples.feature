#A feature file with "Data Table" test examples from second Cucumber story.
#Author: Ivo Boyadzhiev@estafet.com

Feature: Data Table examples from second Training story "IBT-17"
  Test scenarios illustrating the usage of Data Tables

  Background:
    Given I am starting a new test

  @testDataTable
  Scenario: Data table with just one column and usage of List<String>
    Given I have the following student names
      | Keith Murray  |
      | Jill Scott    |
      | Pesho Starev  |
      | James Stewart |
    Then I print them on the screen and we're all happy

  @testDataTable
  Scenario: Data table with two columns and usage of Map<String, String>>
    Given I have the following usernames and credentials
      | bai_stavri@gmail.com | 12345     |
      | JohnntDepp@yahoo.com | SECRET123 |
      | MichaelKane@abv.bg   | 0000000   |
    Then I print them on the screen and we're all happy
