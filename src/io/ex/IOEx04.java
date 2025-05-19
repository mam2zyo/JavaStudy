package io.ex;

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
            System.err.println("파일을 찾지 못했습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("파일 읽기 오류");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "my_diary.txt";

        writeFile(filename);

        readFile(filename);
    }
}