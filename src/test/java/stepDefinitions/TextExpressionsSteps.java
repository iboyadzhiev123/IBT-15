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

    @Given("The first word is {word}")
    public void theFirstWordIs(String word) {
        firstWord = word;
    }

    @And("The second word is {word}")
    public void theSecondWordIs(String word) {
        secondWord = word;
    }

    @Then("I verify that the words are equal")
    public void iVerifyThatTheWordsAreEqual() {
        boolean areEqual = StringHelper.areWordsEqual(firstWord, secondWord, PropertiesHelper.getCaseSensitive());
        Assert.assertTrue("The words are not equal. Check your word values and the caseSensitivity setting", areEqual);
    }

    @Given("The first sentence is {string}")
    public void theFirstSentenceIs(String sentence) {
        firstSentence = sentence;
    }

    @When("The second sentence is {string}")
    public void theSecondSentenceIs(String sentence) {
        secondSentence = sentence;
    }

    @Then("I verify that the sentences are equal")
    public void iVerifyThatTheSentencesAreEqual() {
        boolean areEqual = StringHelper.areSentencesEqual(firstSentence, secondSentence, PropertiesHelper.getCaseSensitive());
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
}
