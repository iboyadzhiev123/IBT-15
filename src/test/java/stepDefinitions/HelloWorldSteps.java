package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelloWorldSteps {
    @Given("I push the big red button")
    public void i_push_the_big_red_button() {
        System.out.println("Pusshhhhhhhh");

    }

    @When("I wait for some time")
    public void i_wait_for_some_time() {
        System.out.println("Waiting for some time");
    }

    @Then("Hello World is being displayed in the console")
    public void hello_world_is_being_displayed_in_the_console() {
        System.out.println("Hello World");
    }

}
