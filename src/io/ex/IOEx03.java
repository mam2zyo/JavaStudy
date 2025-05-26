package io.ex;

/*
    어제 작성했던 프로그램으로 생성된 "my_note.txt" 파일의 내용을 읽어서
    콘솔 화면에 그대로 출력하는 Java 프로그램을 작성해 보세요.

    요구사항:
        1. "my_note.txt" 파일을 읽어야 합니다.
        2. 파일의 전체 내용이 콘솔에 출력되어야 합니다.
        3. 만약 "my_note.txt" 파일이 없다면 "my_note.txt 파일을 찾을 수 없습니다."
           라는 에러 메시지를 출력해야 합니다.
        4. 다른 파일 읽기 오류가 발생하면 적절한 에러 메시지를 출력해야 합니다.
        5. FileInputStream과 try-with-resources 구문을 사용하세요.
        6. 데이터를 읽을 때는 바이트 배열 버퍼를 사용하는 방식(read(byte[] b))을 이용해 보세요.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOEx03 {
    public static void main(String[] args) {
        String filename = "my_note.txt";

        try (FileInputStream fis = new FileInputStream(filename)) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            StringBuilder sb = new StringBuilder();
            while ((bytesRead = fis.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, bytesRead));
            }
            System.out.println("---- " + filename + " file 내용 ----");
            System.out.println(sb.toString());
            System.out.println("---- 파일 내용 끝");
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다");
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생");
            e.printStackTrace();
        }
    }
}