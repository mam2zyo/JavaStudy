package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SimpleFileReader {
    public static void main(String[] args) {
        String filename = "char_output.txt";

        try (FileReader reader = new FileReader(filename)) {
            char[] buffer = new char[1024];
            int charsRead;

            System.out.println("파일 내용:");
            StringBuilder sb = new StringBuilder();

            while ((charsRead = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, charsRead);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("Error has occured");
            e.printStackTrace();
        }
    }
}