package calculator;

public class ModOperator implements Operator {
    @Override
    public <T extends Number> double operate(T num1, T num2) {
        return num1.doubleValue() % num2.doubleValue();
    }
}
