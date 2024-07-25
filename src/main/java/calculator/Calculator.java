package calculator;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.stream.Collectors;

public abstract class Calculator {
    private Queue<Double> resultQueue;

    public Calculator() {
        // 생성될때 resultQueue 초기화
        this.resultQueue = new LinkedList<>();
    }

    public Queue<Double> getResultQueue() {
        return this.resultQueue;
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

    public void inquiryResults() {
        System.out.println("연산 결과: " + this.resultQueue.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]")));
    }
}
