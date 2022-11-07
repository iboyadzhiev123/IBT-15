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

//    @Given("the first word is {word}")
//    public void theFirstWordIs(String word) {
//        firstWord = word;
//    }
    @Given("^the first word is ([a-zA-Z0-9]*)$")
    public void theFirstWordWouldBe(String word) {
        firstWord = word;
    }

    @And("^first occurrence of ([a-z]|[A-Z]|[0-9]) is removed$")
    public void firstOccurrenceOfAIsRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalCharFirst(firstWord, charToBeRemoved);
    }

//    @When("the second word is {word}")
//    public void secondWordIs(String word) {
//        secondWord = word;
//    }

    @Then("we verify that the words are equal")
    public void iVerifyThatTheWordsAreEqual() {
        boolean areEqual = StringHelper.areWordsEqual(firstWord, secondWord, PropertiesHelper.getCaseSensitive());
        System.out.println(String.format("First word: %s Secondword: %s", firstWord, secondWord));
        Assert.assertTrue("The words are not equal. Check your word values and the caseSensitivity setting", areEqual);
    }

    @And("^all occurrences of ([a-z]|[A-Z]|[0-9]) are removed$")
    public void allOccurrencesOfAreRemoved(char charToBeRemoved) {
        firstWord = StringHelper.removeNormalAll(firstWord, charToBeRemoved);
        //firstWord = StringHelper.remove(firstWord, charToBeRemoved);
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
        System.out.println(String.format("First sentence word: %s Second sentence: %s", firstSentence, secondSentence));
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
}
