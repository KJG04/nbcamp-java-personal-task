package calculator;

public class ArithmeticCalculator extends Calculator {
    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;

    public ArithmeticCalculator() {
        super();
        this.addOperator = new AddOperator();
        this.subtractOperator = new SubtractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
    }

    public double calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> this.addOperator.operate(num1, num2);
            case '-' -> this.subtractOperator.operate(num1, num2);
            case '*' -> this.multiplyOperator.operate(num1, num2);
            case '/' -> this.divideOperator.operate(num1, num2);
            default -> throw new IllegalArgumentException("잘못된 사칙연산 기호 입력입니다.");
        };
    }
}
