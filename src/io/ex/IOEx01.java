package io.ex;

/*
    다음 요구사항을 만족하는 간단한 Java 프로그램을 작성해 보세요.

    1. 프로그램을 실행하면 사용자에게 "좋아하는 숫자를 입력하세요: " 라는 메시지를 보여줍니다.
    2. 사용자가 숫자를 입력하고 Enter를 누르면, 해당 숫자를 읽어들입니다.
    3. "당신이 좋아하는 숫자는 [입력한 숫자] 이군요!" 라는 메시지를 콘솔에 출력합니다.
*/

import java.util.Scanner;

public class IOEx01 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("좋아하는 숫자를 입력하세요: ");

            int number = scanner.nextInt();
            scanner.nextLine(); // nextInt() 후에 남아있는 줄바꿈 문자(개행 문자)를 소비하기 위해 추가

            System.out.println("당신이 좋아하는 숫자는 " + number + " 이군요!");

        } // try 블록이 끝나면 scanner.close() 자동 호출
    }
}
