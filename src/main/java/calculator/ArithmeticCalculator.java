package calculator;

public class ArithmeticCalculator extends Calculator {
    private Operator operator;

    public ArithmeticCalculator(Operator operator) {
        super();
        this.operator = operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public double calculate(int num1, int num2) {
        return this.operator.operate(num1, num2);
    }
}
