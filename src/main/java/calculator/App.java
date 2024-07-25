package calculator;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(OperatorType.ADD);
        CircleCalculator circleCalculator = new CircleCalculator();

        while (true) {
            System.out.print("사칙연산을 진행하고 싶으시면 1번. 원의 넓이를 계산하고 싶으시면 2번을 입력해주세요: ");
            int calculateIntent;
            try {
                calculateIntent = sc.nextInt();
                sc.nextLine(); //개행문자 제거
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                sc.nextLine();
                continue;
            }

            if (calculateIntent != 1 && calculateIntent != 2) {
                // 입력이 1, 2가 아님
                System.out.println("1 또는 2를 입력하세요.");
                continue;
            }

            if (calculateIntent == 1) {
                double num1;
                double num2;

                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    num1 = sc.nextInt();
                    sc.nextLine(); //개행문자 제거

                    System.out.print("두 번째 숫자를 입력하세요: ");
                    num2 = sc.nextInt();
                    sc.nextLine(); //개행문자 제거
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    sc.nextLine();
                    continue;
                }

                char operator;
                try {
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    operator = sc.nextLine().charAt(0);
                } catch (StringIndexOutOfBoundsException e) {
                    // sc.nextLine().charAt(0) 에서 오류가 발생했을때
                    System.out.println("잘못된 사칙연산 기호 입력입니다.");
                    continue;
                }

                try {
                    arithmeticCalculator.setOperatorType(OperatorType.getOperatorTypeByOperatorChar(operator));
                    double result = arithmeticCalculator.calculate(num1, num2);
                    System.out.println("결과: " + result);
                    arithmeticCalculator.getResultQueue().add(result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
                String removeIntent = sc.nextLine();
                try {
                    if (removeIntent.equals("remove"))
                        arithmeticCalculator.removeResult();
                } catch (NoSuchElementException e) {
                    System.out.println(e.getMessage());
                }

                System.out.print("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회): ");
                String inquiryIntent = sc.nextLine();
                if (inquiryIntent.equals("inquiry"))
                    arithmeticCalculator.inquiryResults();
            } else {
                int radius;

                try {
                    System.out.print("반지름을 입력하세요: ");
                    radius = sc.nextInt();
                    sc.nextLine(); //개행문자 제거
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    sc.nextLine();
                    continue;
                }

                double result = circleCalculator.calculate(radius);
                System.out.println("결과: " + result);
                circleCalculator.getResultQueue().add(result);
                circleCalculator.inquiryResults();
            }


            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String terminationIntent = sc.nextLine();
            if (terminationIntent.equals("exit"))
                break;
        }
    }
}
