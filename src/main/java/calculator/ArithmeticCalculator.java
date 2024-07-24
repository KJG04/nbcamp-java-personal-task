package calculator;

public class ArithmeticCalculator extends Calculator {
    public double calculate(int num1, int num2, char operator) {
        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                yield (double) num1 / num2;
            }
            default -> throw new IllegalArgumentException("잘못된 사칙연산 기호 입력입니다.");
        };
    }
}
