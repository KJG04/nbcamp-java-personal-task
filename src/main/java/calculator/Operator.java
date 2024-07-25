package calculator;

@FunctionalInterface
public interface Operator {
    public abstract double operate(int num1, int num2);
}
