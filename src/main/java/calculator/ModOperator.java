package calculator;

public class ModOperator implements Operator {
    @Override
    public double operate(int num1, int num2) {
        return num1 % num2;
    }
}
