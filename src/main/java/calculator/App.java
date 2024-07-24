package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> resultQueue = new LinkedList<>();

        while (true) {
            int num1;
            int num2;

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
                        continue;
                }
                System.out.println("결과: " + result);

                // queue의 제일 뒤에 데이터 추가
                resultQueue.add(result);
            } catch (StringIndexOutOfBoundsException e) {
                // sc.nextLine().charAt(0) 에서 오류가 발생했을때
                System.out.println("잘못된 사칙연산 기호 입력입니다.");
                continue;
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): ");
            String removeIntent = sc.nextLine();
            try {
                if (removeIntent.equals("remove"))
                    resultQueue.remove();
            } catch (NoSuchElementException e) {
                System.out.println("삭제할 연산 결과가 없습니다.");
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String terminationIntent = sc.nextLine();
            if (terminationIntent.equals("exit"))
                break;

        }
    }
}
