package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] resultList = new int[5];
        int resultListIndex = 0;

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
                if (resultListIndex >= resultList.length) {
                    // resultList가 꽉 찼을때 배열을 앞으로 한칸씩 민다.
                    for (int i = 1; i < resultList.length; i++) {
                        resultList[i - 1] = resultList[i];
                    }
                    // 결과 배열에 저장
                    resultList[resultList.length - 1] = result;
                } else {
                    // 결과 배열에 저장
                    resultList[resultListIndex] = result;
                }

                // 다음에 저장할 위치를 바꾼다
                // 최대로 resultList.length이 되게끔 함
                resultListIndex = Math.min(resultList.length, resultListIndex + 1);
            } catch (StringIndexOutOfBoundsException e) {
                // sc.nextLine().charAt(0) 에서 오류가 발생했을때
                System.out.println("잘못된 사칙연산 기호 입력입니다.");
                continue;
            } catch (ArithmeticException e) {
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            String terminationIntent = sc.nextLine();
            if (terminationIntent.equals("exit"))
                break;
        }
    }
}
