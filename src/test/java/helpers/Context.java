package helpers;

public class Context {
    private Calculator calculator;

    private double firstValue;
    private double secondValue;
    private double result;

    public Context(Calculator calculator) {
        this.calculator = calculator;
        this.setFirstValue(0);
        this.setSecondValue(0);
        this.setResult(0);
    }

    public double getFirstValue() {
        return this.firstValue;
    }

    public void setFirstValue(double value) {
        this.firstValue = value;
    }

    public double getSecondValue() {
        return this.secondValue;
    }

    public void setSecondValue(double value) {
        this.secondValue = value;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double calculate(double num1, double num2) {
        double result = calculator.calculate(num1, num2);
        setResult(result);
        return result;
    }
}
