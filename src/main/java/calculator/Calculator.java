package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Calculator {
    private Queue<Double> resultQueue;

    public Calculator() {
        this.resultQueue = new LinkedList<>();
    }

    public double calculate(int num1, int num2, char operator) {
        double result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                yield (double) num1 / num2;
            }
            default -> throw new IllegalArgumentException("잘못된 사칙연산 기호 입력입니다.");
        };

        resultQueue.add(result);
        return result;
    }

    public Queue<Double> getResultQueue() {
        return resultQueue;
    }

    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public void removeResult() {
        if (this.resultQueue.isEmpty())
            throw new NoSuchElementException("삭제할 연산 결과가 없습니다.");

        // resultQueue 에서 첫번째 요소 삭제
        this.resultQueue.remove();
    }
}
