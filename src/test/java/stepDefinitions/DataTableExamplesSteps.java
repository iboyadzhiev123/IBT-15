package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTableExamplesSteps {

    @Given("I have the following student names")
    public void iHaveTheFollowingStudentNames(DataTable dataTable) {
        List<String> students = dataTable.asList();
        for (String student : students)
            System.out.println(String.format("The student %s is properly signed up for the next semester", student));
    }

    @Then("I print them on the screen and we're all happy")
    public void iPrintThemOnTheScreen() {
        System.out.println("They're all printed on the screen");
    }

    @Given("I have the following usernames and credentials")
    public void iHaveTheFollowingUsernamesAndCredentials(DataTable dataTable) {
        Map<String, String> usersAndCreds = dataTable.asMap();
        for (Map.Entry<String, String> entry : usersAndCreds.entrySet())
            System.out.println(String.format("User %s has a %s password", entry.getKey(), entry.getValue()));
    }

    @Given("I am starting a new test")
    public void iAmStartingANewTest() {
        System.out.println("Starting a new test");
    }
}
