package stepDefinitions;

import helpers.Context;
import helpers.SumCalculatorHelper;
import helpers.DifferenceCalculatorHelper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NumericExpressionsSteps {
    Context context;
    @Given("I want to find the {calculatorType} of {double} and {double}")
    public void iWantToFindTheirSum(String calculatorType, double value1, double value2) {
        if(calculatorType.equals("sum"))
            context = new Context(new SumCalculatorHelper());
        else
            context = new Context(new DifferenceCalculatorHelper());
        double result = context.calculate(value1,value2);
        System.out.println(String.format("The %s of %s and %s is %s", calculatorType, value1, value2, result));
    }

    @Then("I'd like to verify that the expected result is {double}")
    public void iDLikeToVerifyThatTheResultIs(double expectedResult) {
        Assert.assertEquals(expectedResult, context.result,0);
    }

    @Given("I wanna find the sum of {double} and {double}")
    public void iWannaFindTheSumOfAnd(double value1, double value2) {
        context = new Context(new SumCalculatorHelper());
        double result = context.calculate(value1,value2);
        System.out.println(String.format("The sum of %s and %s is %s", value1, value2, result));
    }
    @Given("I wanna find the difference of {double} and {double}")
    public void iWannaFindTheDiffOfAnd(double value1, double value2) {
        context = new Context(new DifferenceCalculatorHelper());
        double result = context.calculate(value1,value2);
        System.out.println(String.format("The diff of %s and %s is %s", value1, value2, result));
    }

    @ParameterType("sum|difference")
    public String calculatorType(String value){
        return value;
    }
}
