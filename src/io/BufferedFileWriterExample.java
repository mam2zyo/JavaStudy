package io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileWriterExample {
    public static void main(String[] args) {
        String filename = "buffered_output.txt";
        String[] lines = {
                "첫 번째 줄입니다.",
                "두 번째 줄, 안녕하세요!",
                "세 번째 줄, BufferedWriter 테스트 중입니다."
        };

        try (FileWriter fw = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            System.out.println("파일 '" + filename + "'에 성공적으로 " +
                    "정정했습니다(BuffedWriter 사용");
        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
