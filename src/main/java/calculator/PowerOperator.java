package calculator;

public class PowerOperator implements Operator {
    @Override
    public <T extends Number> double operate(T num1, T num2) {
        return Math.pow(num1.doubleValue(), num2.doubleValue());
    }
}
