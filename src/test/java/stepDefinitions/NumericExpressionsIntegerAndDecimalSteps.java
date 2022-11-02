package stepDefinitions;

import helpers.Calculator;
import helpers.DifferenceCalculatorHelper;
import helpers.SumCalculatorHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class NumericExpressionsIntegerAndDecimalSteps {
    public Calculator calcInstance;
    public double firstValue = 0;
    public double secondValue = 0;
    public double result = 0;
    public double expectedResult = 0;
    public double intCalcFirst;
    public double intCalcSecond;
    public double decCalcFirst;
    public double decCalcSecond;

    @Given("I set the calculator type to {calcType}")
    public void iSetTheCalculatorTypeToSum(Calculator calculator) {
        calcInstance = calculator;
    }

    @Given("the first int value is {int}")
    public void theFirstValueIsInput(int firstValue) {

        this.firstValue = firstValue;
        System.out.println(String.format("The first int value is: %s", firstValue));
    }

    @And("the second int value is {int}")
    public void theSecondValueIsInput(int secondValue) {

        this.secondValue = secondValue;
        System.out.println(String.format("The second int value is: %s", secondValue));
    }

    @Then("I expect the int result to be {int}")
    public void iExpectTheResultToBeExpected(int expectedResult) {
        this.result = calcInstance.calculate(this.firstValue, this.secondValue);
        this.expectedResult = expectedResult;
        System.out.println(String.format("The int result is: %s and the expected result is %s", result, expectedResult));
        //Assert.assertEquals(result, expectedResult, 0);
        Assert.assertEquals("The expected and actual integer results are different", result, expectedResult, 0);
    }

    @Given("the first dec value is {double}")
    public void theFirstDecValueIsInput(double firstValue) {
        this.firstValue = firstValue;
        System.out.println(String.format("The first dec value is: %s", firstValue));
    }

    @Given("the second dec value is {double}")
    public void theSecondDecValueIsInput(double secondValue) {
        this.secondValue = secondValue;
        System.out.println(String.format("The second dec value is: %s", secondValue));
    }

    @Then("I expect the dec result to be {double}")
    public void iExpectTheResultToBeExpected(double expectedResult) {
        this.result = calcInstance.calculate(this.firstValue, this.secondValue);
        this.expectedResult = expectedResult;
        System.out.println(String.format("The dec result is: %s and the expected result is %s", result, expectedResult));
        Assert.assertEquals("The expected and actual decimal results are different", result, expectedResult, 0);
    }

    @Given("I have the following columns with integers to sum")
    public void iHaveTheFollowingColumnsWithIntegersToSum(DataTable dataTable) {
        List<List<Integer>> rows = dataTable.asLists(Integer.class);
        for (List<Integer> columns : rows) {
            intCalcFirst = calcInstance.calculate(intCalcFirst, columns.get(0));
            intCalcSecond = calcInstance.calculate(intCalcSecond, columns.get(1));
        }
        System.out.println(String.format("The sum for first column is %s\nThe sum for second column is %s", intCalcFirst, intCalcSecond));
    }

    @Given("I have the following columns with integers to subtract")
    public void iHaveTheFollowingColumnsWithIntegersToSubtract(DataTable dataTable) {
        List<List<Integer>> rows = dataTable.asLists(Integer.class);
        intCalcFirst = rows.get(0).get(0);
        intCalcSecond = rows.get(0).get(1);
        for (int i = 1; i < rows.size(); i++) {
            intCalcFirst = calcInstance.calculate(intCalcFirst, rows.get(i).get(0));
            intCalcSecond = calcInstance.calculate(intCalcSecond, rows.get(i).get(1));
        }
        System.out.println(String.format("The difference for first column is %s\nThe difference for second column is %s", intCalcFirst, intCalcSecond));
    }

    @And("I'd like to find out which integer column has a bigger calculation")
    public void iDLikeToFindOutWhichIntegerColumnHasABiggerCalculation() {
        if (intCalcFirst > intCalcSecond)
            System.out.println("The first column has a bigger calculation");
        else if (intCalcFirst < intCalcSecond)
            System.out.println("The second column has a bigger calculation");
        else
            System.out.println("The sums for both columns are equal");
    }

    @Given("I have the following column(s) with decimals to sum")
    public void iHaveTheFollowingColumnsWithDecimalsToSum(DataTable dataTable) {
        List<List<Double>> rows = dataTable.asLists(Double.class);
        for (List<Double> columns : rows) {
            decCalcFirst = calcInstance.calculate(decCalcFirst, columns.get(0));
            decCalcSecond = calcInstance.calculate(decCalcSecond, columns.get(1));
        }
        System.out.println(String.format("The sum for first column is %s\nThe sum for second column is %s", decCalcFirst, decCalcSecond));
    }

    @Given("I have the following columns with decimals to subtract")
    public void iHaveTheFollowingColumnsWithDecimalsToSubtract(DataTable dataTable) {
        List<List<Double>> rows = dataTable.asLists(Double.class);
        decCalcFirst = rows.get(0).get(0);
        decCalcSecond = rows.get(0).get(1);
        for (int i = 1; i < rows.size(); i++) {
            decCalcFirst = calcInstance.calculate(decCalcFirst, rows.get(i).get(0));
            decCalcSecond = calcInstance.calculate(decCalcSecond, rows.get(i).get(1));
        }
        System.out.println(String.format("The difference for first column is %s\nThe difference for second column is %s", decCalcFirst, decCalcSecond));
    }

    @And("I'd like to find out which decimal column has a bigger calculation")
    public void iDLikeToFindOutWhichDecimalIntegerColumnHasABiggerCalculation() {
        if (decCalcFirst > decCalcSecond)
            System.out.println("The first column has a bigger calculation");
        else if (decCalcFirst < decCalcSecond)
            System.out.println("The second column has a bigger calculation");
        else
            System.out.println("The sums for both columns are equal");
    }

    @ParameterType("sum|difference")
    public Calculator calcType(String value) {
        Calculator calc = (value.equals("sum")) ? new SumCalculatorHelper() : new DifferenceCalculatorHelper();
        return calc;
    }
}
