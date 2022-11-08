package stepDefinitions;

import helpers.PropertiesHelper;
import helpers.StringHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TextExpressionsSteps {
    private String firstWord;
    private String secondWord;
    private String firstSentence;
    private String secondSentence;

    private String paragraph;
    private int wordOrCharCount;

    @Given("I read the configuration")
    public void iReadTheConfiguration() {
        PropertiesHelper.initialize();
    }

    @Given("the first word is {word}")
    public void theFirstWordIs(String word) {
        firstWord = word;
    }

    @And("the second word is {word}")
    public void theSecondWordIs(String word) {
        secondWord = word;
    }

    @Then("I verify that the words are equal")
    public void iVerifyThatTheWordsAreEqual() {
        boolean areEqual = StringHelper.areWordsEqual(firstWord, secondWord, PropertiesHelper.getCaseSensitive());
        System.out.println(String.format("First word: %s Second word: %s", firstWord, secondWord));
        Assert.assertTrue("The words are not equal. Check your word values and the caseSensitivity setting", areEqual);
    }

    @Given("the first sentence is {string}")
    public void theFirstSentenceIs(String sentence) {
        firstSentence = sentence;
    }

    @When("the second sentence is {string}")
    public void theSecondSentenceIs(String sentence) {
        secondSentence = sentence;
    }

    @Then("I verify that the sentences are equal")
    public void iVerifyThatTheSentencesAreEqual() {
        boolean areEqual = StringHelper.areSentencesEqual(firstSentence, secondSentence, PropertiesHelper.getCaseSensitive());
        System.out.println(String.format("First sentence: %s Second sentence: %s", firstSentence, secondSentence));
        Assert.assertTrue("The sentences are not equal. Check you sentence values and the caseSensitivity setting", areEqual);
    }

    @Given("I pass the following text/paragraph :")
    public void iPassTheFollowingTextOrParagraph(String passedParagraph) {
        paragraph = passedParagraph;
    }

    @When("^I get the (word|char) count$")
    public void iGetTheWordOrCharCount(String alternativeText) {
        wordOrCharCount = alternativeText.equals("word") ? StringHelper.getWordsCountFromText(paragraph) : StringHelper.getCharsCount(paragraph);
    }

    @Then("I verify the count is equal to {int}")
    public void iVerifyTheCountIsEqualTo(int count) {
        Assert.assertEquals("The count is different than the expected.", wordOrCharCount, count);
    }

    @And("^first occurrence of ([a-z]|[A-Z]) is removed$")
    public void firstOccurrenceOfAIsRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalCharFirst(firstWord, charToBeRemoved);
    }

    @And("^all occurrences of ([0-9]) are removed$")
    public void allOccurrencesOfAreRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalAll(firstWord, charToBeRemoved);
    }

    @And("^first occurrence of ([\\:,\\(,\\),\\{,\\},\\[,\\]]) is removed from a sentence$")
    public void firstOccurrenceOfIsRemovedFromASentence(char charToBeRemoved) {
        firstSentence = StringHelper.removeCharFirst(firstSentence, charToBeRemoved);
    }

    @And("^all occurrences of ([\\.,\\?,\\!,\\;,\\,,\\-,\\']) are removed from a sentence$")
    public void allOccurrencesOfAreRemovedFromASentence(char charToBeRemoved) {
        firstSentence = StringHelper.removeAll(firstSentence, charToBeRemoved);
    }

    @When("^all whitespaces before ([\\.,\\?,\\!,\\,,\\-,\\:]) are removed$")
    public void allWhitespacesBeforeAreRemoved(char charWithSpaces) {
        paragraph = StringHelper.removeAllSpacesBeforeChar(paragraph, charWithSpaces);
    }

    @And("all consecutive whitespace chars are replaced with a single space")
    public void allConsecutiveWhitespaceCharsAreReplacedWithASingleSpace() {
        paragraph = StringHelper.replaceAllMultipleWhitespaces(paragraph);
    }
}
