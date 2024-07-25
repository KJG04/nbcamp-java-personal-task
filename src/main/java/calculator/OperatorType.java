package calculator;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorType {
    // 람다식으로 표현 가능
    // ADD('+', ((num1, num2) -> num1 + num2)),
    ADD('+', new AddOperator()),
    SUBTRACT('-', new SubtractOperator()),
    MULTIPLY('*', new MultiplyOperator()),
    DIVIDE('/', new DivideOperator()),
    MOD('%', new ModOperator());

    private final char operatorChar;
    private final Operator operator;

    private OperatorType(char operatorChar, Operator operator) {
        this.operatorChar = operatorChar;
        this.operator = operator;
    }

    public <T extends Number> double operate(T num1, T num2) {
        return this.operator.operate(num1, num2);
    }

    static OperatorType getOperatorTypeByOperatorChar(char operatorChar) {
        // 전달받은 operatorChar를 가지고 있는 OperatorType을 찾음
        Optional<OperatorType> optional = Arrays.stream(OperatorType.values()).filter(v -> v.operatorChar == operatorChar).findFirst();
        if (optional.isPresent())
            return optional.get();

        throw new IllegalArgumentException("잘못된 사칙연산 기호 입력입니다.");
    }
}
