package calculator;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();
        sc.nextLine(); //개행문자 제거

        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt();
        sc.nextLine(); //개행문자 제거

        try {
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0);
            int result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("잘못된 사칙연산 기호 입력입니다.");
                    return;
            }
            System.out.println("결과: " + result);

        } catch (StringIndexOutOfBoundsException e) {
            // sc.nextLine().charAt(0) 에서 오류가 발생했을때
            System.out.println("잘못된 사칙연산 기호 입력입니다.");
        } catch (ArithmeticException e) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }
}
