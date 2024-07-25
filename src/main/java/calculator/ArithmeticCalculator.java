package calculator;

public class ArithmeticCalculator extends Calculator {
    private OperatorType operatorType;

    public ArithmeticCalculator(OperatorType operatorType) {
        super();
        this.operatorType = operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public <T extends Number> double calculate(T num1, T num2) {
        return this.operatorType.operate(num1, num2);
    }
}
