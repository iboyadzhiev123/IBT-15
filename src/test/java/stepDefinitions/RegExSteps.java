package stepDefinitions;

import helpers.PropertiesHelper;
import helpers.StringHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegExSteps {

    private String firstWord;
    private String secondWord;

    private String firstSentence;
    private String secondSentence;
    private String paragraph;
    private int wordCount;
    private int charCount;

    @Given("^the first word is ([a-zA-Z0-9]*)$")
    public void theFirstWordWouldBe(String word) {
        firstWord = word;
    }

    @And("^first occurrence of ([a-z]|[A-Z]|[0-9]) is removed$")
    public void firstOccurrenceOfAIsRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalCharFirst(firstWord, charToBeRemoved);
    }

    @Then("we verify that the words are equal")
    public void iVerifyThatTheWordsAreEqual() {
        boolean areEqual = StringHelper.areWordsEqual(firstWord, secondWord, PropertiesHelper.getCaseSensitive());
        System.out.println(String.format("First word: %s Second word: %s", firstWord, secondWord));
        Assert.assertTrue("The words are not equal. Check your word values and the caseSensitivity setting", areEqual);
    }

    @And("^all occurrences of ([a-z]|[A-Z]|[0-9]) are removed$")
    public void allOccurrencesOfAreRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalAll(firstWord, charToBeRemoved);
    }

    @Given("first sentence is {string}")
    public void firstSentenceIs(String sentence) {
        firstSentence = sentence;
    }

    @When("second sentence is {string}")
    public void secondSentenceIs(String sentence) {
        secondSentence = sentence;
    }

    @Then("we verify that the sentences are equal")
    public void weVerifyThatTheSentencesAreEqual() {
        boolean areEqual = StringHelper.areSentencesEqual(firstSentence, secondSentence, PropertiesHelper.getCaseSensitive());
        System.out.println(String.format("First sentence: %s Second sentence: %s", firstSentence, secondSentence));
        Assert.assertTrue("The sentences are not equal. Check you sentence values and the caseSensitivity setting", areEqual);
    }

    @And("^first occurrence of ([a-z]|[A-Z]|[0-9]|[\\:,\\(,\\),\\{,\\},\\[,\\]]) is removed from a sentence$")
    public void firstOccurrenceOfIsRemovedFromASentence(char charToBeRemoved) {
        firstSentence = StringHelper.removeCharFirst(firstSentence, charToBeRemoved);
    }

    @When("^the second word is ([a-zA-Z0-9]*)$")
    public void theSecondWordWouldBe(String word) {
        this.secondWord = word;
    }

    @And("^all occurrences of ([a-z]|[A-Z]|[0-9]|[\\.,\\?,\\!,\\;,\\,,\\-,\\']) are removed from a sentence$")
    public void allOccurrencesOfAreRemovedFromASentence(char charToBeRemoved) {
        firstSentence = StringHelper.removeAll(firstSentence, charToBeRemoved);
    }

    @Given("input text")
    public void inputText(String passedParagraph) {
        paragraph = passedParagraph;
    }

    @When("^I get the word count$")
    public void iGetTheWordCount() {
        wordCount = StringHelper.getWordsCountFromText(paragraph);
    }

    @When("^I get the char count$")
    public void iGetTheCharCount() {
        charCount = StringHelper.getWordsCountFromText(paragraph);
    }

    @Then("I verify the word count is equal to {int}")
    public void iVerifyTheWordCountIsEqualTo(int count) {
        Assert.assertEquals("The count is different than the expected.", wordCount, count);
    }

    @Then("I verify the char count is equal to {int}")
    public void iVerifyTheCharCountIsEqualTo(int count) {
        Assert.assertEquals("The count is different than the expected.", charCount, count);
    }

    @When("^all whitespaces before ([\\.,\\?,\\!,\\,,\\-,\\:]) are removed$")
    public void allWhitespacesBeforeAreRemoved(char charWithSpaces) {
        paragraph = StringHelper.removeAllSpacesBeforeChar(paragraph, charWithSpaces);
    }

    @And("all consecutive whitespace chars are replaced with a single space")
    public void allConsecutiveWhitespaceCharsAreReplacedWithASingleSpace() {
        paragraph = StringHelper.replaceAllMultipleWhitespaces(paragraph);
    }

    @Then("I verify the input text word count is equal to {int}")
    public void iVerifyTheInputTextWordCountIsEqualTo(int count) {
        wordCount = StringHelper.getWordsCountFromText(paragraph);
        Assert.assertEquals("The word count is different that the expected", wordCount, count);
    }

    @And("I verify the input text char count is equal to {int}")
    public void iVerifyTheInputTextCharCountIsEqualTo(int count) {
        charCount = StringHelper.getCharsCount(paragraph);
        Assert.assertEquals("The char count is different that the expected", charCount, count);
    }
}
