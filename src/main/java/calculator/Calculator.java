package calculator;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Calculator {
    private Queue<Double> resultQueue;
    private Queue<Double> circleAreaResultQueue;
    // PI는 절대 변하지 않는 값이여서 final을 사용하고 객체 생성 없이 사용할 수 있도록 static을 사용한다.
    private static final double PI = 3.141592653589793;

    public Calculator() {
        // 생성될때 resultQueue 초기화
        this.resultQueue = new LinkedList<>();
        this.circleAreaResultQueue = new LinkedList<>();
    }

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

    public double calculateCircleArea(int radius) {
        return Calculator.PI * Math.pow(radius, 2);
    }

    public Queue<Double> getResultQueue() {
        return this.resultQueue;
    }

    public void setResultQueue(Queue<Double> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public Queue<Double> getCircleAreResultQueue() {
        return this.circleAreaResultQueue;
    }

    public void setCircleAreResultQueue(Queue<Double> circleAreaResultQueue) {
        this.circleAreaResultQueue = circleAreaResultQueue;
    }

    public void removeResult() {
        if (this.resultQueue.isEmpty())
            throw new NoSuchElementException("삭제할 연산 결과가 없습니다.");

        // resultQueue 에서 첫번째 요소 삭제
        this.resultQueue.remove();
    }

    private <T> void inquiryCollection(Collection<T> list) {
        System.out.print("[");
        int index = 0;
        for (T v : list) {
            System.out.print(v);
            if (index != list.size() - 1)
                System.out.print(", ");
            index++;
        }
        System.out.println("]");
    }

    public void inquiryResults() {
        System.out.print("연산 결과: ");
        this.inquiryCollection(this.resultQueue);
    }

    public void inquiryCircleAreaResults() {
        System.out.print("연산 결과: ");
        this.inquiryCollection(this.circleAreaResultQueue);
    }
}
