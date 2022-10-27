package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.regex.Pattern;

public class AnonExpressionsSteps {
    @Given("^I (am|am not) at the registration form$")
    public void iAmAtTheRegistrationForm(String optionalValue) {
        if(optionalValue.equals("am"))
            System.out.println("The user is at the registration form");
        else
            System.out.println("The user is at the beach and doesn't care");
    }

    @And("I insert {string} name")
    public void iInsertJohnKirilovName(String name) {
        System.out.println(String.format("Name %s has been inserted", name));
    }

    @And("I insert {double} years of age")
    public void iInsertYearsOfAge(double age) {
        System.out.println(String.format("Age %s has been inserted", age));

    }

    @And("I my lucky number is {int}")
    public void iMyLuckyNumberIs(int luckyNumber) {
        System.out.println(String.format("Lucky number %s has been inserted", luckyNumber));
    }

    @And("I choose {word} as my secret")
    public void iChooseApplepieAsMySecret(String word) {
        System.out.println(String.format("Word %s has been inserted as a secret", word));
    }

    @And("I insert {string} as e-mail address")
    public void iInsertAsEMailAddress(String email) {
        String regexPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if(Pattern.compile(regexPattern).matcher(email).matches())
            System.out.println(String.format("A proper email %s has been inserted",email));
        else
            System.out.println(String.format("A improper email %s has been inserted",email));
    }

    @Then("I don't wanna be bothered")
    public void iDonTWannaBeBothered() {
        System.out.println("The user is chilling and doesn't care much");
    }
}
