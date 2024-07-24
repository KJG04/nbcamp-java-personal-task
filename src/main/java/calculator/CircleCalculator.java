package calculator;

public class CircleCalculator extends Calculator {
    // PI는 절대 변하지 않는 값이여서 final을 사용하고 객체 생성 없이 사용할 수 있도록 static을 사용한다.
    private static final double PI = 3.141592653589793;

    public double calculate(int radius) {
        return CircleCalculator.PI * Math.pow(radius, 2);
    }
}
