package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReaderExample {
    public static void main(String[] args) {
        String filename = "buffered_output.txt";

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            System.out.println("'" + filename + "'  file 내용" +
                    "(BufferedReader 사용):");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
