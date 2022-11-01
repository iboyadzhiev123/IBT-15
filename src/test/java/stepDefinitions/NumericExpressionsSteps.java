package stepDefinitions;

import helpers.Context;
import helpers.DifferenceCalculatorHelper;
import helpers.SumCalculatorHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class NumericExpressionsSteps {
    Context context;

    @Given("I want to find the {calculatorType} of {double} and {double}")
    public void iWantToFindTheirSum(String calculatorType, double value1, double value2) {
        if (calculatorType.equals("sum"))
            context = new Context(new SumCalculatorHelper());
        else
            context = new Context(new DifferenceCalculatorHelper());
        double result = context.calculate(value1, value2);
        System.out.println(String.format("The %s of %s and %s is %s", calculatorType, value1, value2, result));
    }

    @Then("I'd like to verify that the expected result is {double}")
    public void iDLikeToVerifyThatTheResultIs(double expectedResult) {
        if (context.getResult() == expectedResult)
            System.out.println("The test has passed");
        else
            System.out.println("The test has failed");
        Assert.assertEquals(expectedResult, context.getResult(), 0);
    }

    @Given("I have the following columns with numbers and I'd like to find the {calculatorType} for each column and to compare them")
    public void iHaveTheFollowingColumnsWithNumbersAndIDLikeToFindTheSumForEachColumnAndToCompareThem(String calculatorType, DataTable dataTable) {
        if (calculatorType.equals("sum")) {
            context = new Context(new SumCalculatorHelper());
            double sumFirst, sumSecond;
            sumFirst = sumSecond = 0;
            List<List<Double>> rows = dataTable.asLists(Double.class);
            for (List<Double> columns : rows) {
                sumFirst = context.calculate(sumFirst, columns.get(0));
                sumSecond = context.calculate(sumSecond, columns.get(1));
            }
            System.out.println(String.format("The sum for first column is %s\nThe sum for second column is %s", sumFirst, sumSecond));
            if (sumFirst > sumSecond)
                System.out.println("The first column has a bigger sum");
            else if (sumFirst < sumSecond)
                System.out.println("The second column has a bigger sum");
            else
                System.out.println("The sums for both columns are equal");
        } else {
            context = new Context(new DifferenceCalculatorHelper());
            double diffFirst, diffSecond;
            List<List<Double>> rows = dataTable.asLists(Double.class);
            diffFirst = rows.get(0).get(0);
            diffSecond = rows.get(0).get(1);
            for (int i = 1; i < rows.size(); i++) {
                diffFirst = context.calculate(diffFirst, rows.get(i).get(0));
                diffSecond = context.calculate(diffSecond, rows.get(i).get(1));
            }
            System.out.println(String.format("The difference for first column is %s\nThe difference for second column is %s", diffFirst, diffSecond));
            if (diffFirst > diffSecond)
                System.out.println("The first column has a bigger calculated difference");
            else if (diffFirst < diffSecond)
                System.out.println("The second column has a bigger calculated difference");
            else
                System.out.println("The calculated differences for both columns are equal");
        }
    }

    @ParameterType("sum|difference")
    public String calculatorType(String value) {
        return value;
    }
}
