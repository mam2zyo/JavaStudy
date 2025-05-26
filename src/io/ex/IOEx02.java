package io.ex;

/*
    다음 요구사항을 만족하는 Java 프로그램을 작성해 보세요.

    1. 프로그램을 실행하면 사용자에게 "파일에 저장할 내용을 입력하세요: " 라는 메시지를 보여줍니다.
    2. 사용자가 키보드로 내용을 입력하고 Enter를 누르면, 해당 내용을 읽어들입니다. (Scanner 사용)
    3. 입력받은 내용을 "my_note.txt" 라는 파일에 저장합니다.
    4. 저장이 완료되면 "my_note.txt 파일에 성공적으로 저장했습니다." 라는 메시지를 콘솔에 출력합니다.
    5. 파일 쓰기 중 오류가 발생하면 적절한 에러 메시지를 출력합니다.
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class IOEx02 {
    public static void main(String[] args) {

        String filename = "my_note.txt";
        String userInput = ""; // 초기값을 주는 것이 좋습니다.

        // 1. 사용자 입력 받기
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("파일에 저장할 내용을 입력하세요: ");
            userInput = scanner.nextLine();
        } // scanner는 여기서 자동으로 close() 됩니다.

        // 2. 파일에 쓰기
        try (FileOutputStream fos = new FileOutputStream(filename)) {

            byte[] bytes = userInput.getBytes();    // 문자열을 바이트 배열로 변환 (시스템 기본 인코딩)
            fos.write(bytes);                       // 파일에 바이트 배열 쓰기

            System.out.println("'" + filename + "' 파일에 성공적으로 저장했습니다.");

        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace(); // 개발/디버깅 시 유용한 스택 트레이스 출력

        } catch (Exception e) { // 혹시 모를 다른 예외 처리 (선택적)
            System.err.println("예상치 못한 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
