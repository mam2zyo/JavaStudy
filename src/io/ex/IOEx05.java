package io.ex;

/*
    어제 작성했던 "여러 줄의 텍스트를 입력받아 파일에 저장하고, 다시 읽어와 콘솔에 출력하는
    프로그램"을 BufferedReader와 BufferedWriter를 사용하도록 수정해 보세요.

    요구사항:
    1. 사용자로부터 여러 줄의 텍스트를 입력받습니다. 사용자가 특정 단어
       (예: "exit")를 입력할 때까지 계속 입력을 받습니다. (Scanner 사용)
    2. 입력받은 모든 텍스트 내용을 "my_buffered_diary.txt" 라는 파일에 저장합니다.
    3. 파일에 쓸 때는 BufferedWriter 를 사용하고,
       각 줄을 쓸 때마다 newLine() 메소드를 사용하여 줄바꿈을 합니다.
    4. 파일 저장이 완료되면, 저장된 "my_buffered_diary.txt" 파일의
       내용을 다시 읽어와 콘솔에 그대로 출력합니다.
    5. 파일을 읽을 때는 BufferedReader 를 사용하고,
       readLine() 메소드를 사용하여 한 줄씩 읽어옵니다.
    6  모든 I/O 스트림은 try-with-resources를 사용하고, 가장 바깥쪽 스트림만
       명시적으로 선언합니다.
       (예: try (BufferedWriter bw = new BufferedWriter(new FileWriter(...))))
    7. 적절한 예외 처리를 포함하세요.
*/

import java.io.*;
import java.util.Scanner;

public class IOEx05 {
    public static void bufferedWriteFile(String filename) {
        try (BufferedWriter bw =
                     new BufferedWriter(new FileWriter(filename));
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("문장을 입력하세요.");
                String line = scanner.nextLine();

                if (line.equals("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                bw.write(line);
                bw.newLine();
            }
            System.out.println("파일 쓰기 완료");
        } catch (IOException e) {
            System.err.println("파일 쓰기 오류: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void bufferedReadFile(String filename) {
        try (BufferedReader br =
                     new BufferedReader(new FileReader(filename))) {

            String line;
            System.out.println("파일 내용:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("파일 찾기 오류: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "my_buffered_diary.txt";

        bufferedWriteFile(filename);
        bufferedReadFile(filename);

    }
}