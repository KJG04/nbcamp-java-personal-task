package calculator;

public class DivideOperator {
    double operate(int num1, int num2) {
        if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return (double) num1 / num2;
    }
}
