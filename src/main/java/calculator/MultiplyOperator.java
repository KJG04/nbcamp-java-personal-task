package calculator;

public class MultiplyOperator implements Operator {
    public <T extends Number> double operate(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }
}
