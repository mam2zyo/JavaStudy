package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class SimpleFileOutput {
    public static void main(String[] args) {

        String filename = "output.txt";   // project root 에 파일 생성
        String content = "Hello, Java I/O";

        try (FileOutputStream fos = new FileOutputStream(filename)) {

            byte[] bytes = content.getBytes();  // 문자열을 바이트 배열로 변환
            fos.write(bytes);                   // write() 메서드로 바이트 배열의 내용을
                                                // 파일에 씀
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}