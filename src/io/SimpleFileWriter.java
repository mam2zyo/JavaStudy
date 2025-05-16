package io;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {

    public static void main(String[] args) {
        String filename = "char_output.txt";
        String content = "안녕하세요. 문자 스트림입니다. \n" +
                "Java I/O 재미있네요.";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}