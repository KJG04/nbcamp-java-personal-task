package calculator;

@FunctionalInterface
public interface Operator {
    public abstract <T extends Number> double operate(T num1, T num2);
}
