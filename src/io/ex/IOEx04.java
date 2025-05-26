package io.ex;

/*
    다음 요구사항을 만족하는 Java 프로그램을 작성해 보세요.

    1. 사용자로부터 여러 줄의 텍스트를 입력받습니다.
       사용자가 특정 단어(예: "exit")를 입력할 때까지 계속 입력을 받습니다. (Scanner의 nextLine() 사용)
    2. 입력받은 모든 텍스트 내용을 "my_diary.txt" 라는 파일에 저장합니다.
       각 줄은 파일에도 개행되어 저장되어야 합니다.
    3. 파일 저장이 완료되면, 저장된 "my_diary.txt" 파일의 내용을 다시 읽어와 콘솔에 그대로 출력합니다.
    4. FileWriter와 FileReader를 사용하세요.
    5. 모든 I/O 작업은 try-with-resources를 사용하고, 적절한 예외 처리를 포함하세요.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOEx04 {

    public static void writeFile(String filename) {
        try (FileWriter writer = new FileWriter(filename);
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("문장을 입력하세요.");
                String line = scanner.nextLine();

                if (line.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                writer.write(line);
                writer.write("\n");
            }
            System.out.println("파일 쓰기 완료");
        } catch (IOException e) {
            System.err.println("파일 쓰기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void readFile(String filename) {
        try (FileReader reader = new FileReader(filename)) {

            char[] buffer = new char[1024];
            int charsRead;

            System.out.println("파일 내용:");

            while ((charsRead = reader.read(buffer)) != -1) {
                String str = new String(buffer, 0, charsRead);
                System.out.print(str);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            System.err.println("파일 찾기 오류: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "my_diary.txt";

        writeFile(filename);
        readFile(filename);
    }
}