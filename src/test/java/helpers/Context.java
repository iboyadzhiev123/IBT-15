package helpers;

public class Context {
    private Calculator calculator;

    public double firstValue;
    public double secondValue;
    public double result;
    public String expectedStatus;

    public Context (Calculator calculator){
        this.calculator = calculator;
        this.firstValue = this.secondValue = this.result = 0;
    }
    public double calculate(double num1, double num2){
        result = calculator.calculate(num1, num2);
        return calculator.calculate(num1, num2);
    }
}
