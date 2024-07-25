package calculator;

public class DivideOperator implements Operator {
    public <T extends Number> double operate(T num1, T num2) {
        if (num2.doubleValue() == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        return num1.doubleValue() / num2.doubleValue();
    }
}
