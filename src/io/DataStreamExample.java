package io;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        String filename = "primitive_data.dat";

        // 1. DataOutputStream을 사용하여 데이터 쓰기
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {

            dos.writeInt(123);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Hello, Data Stream!");
            dos.writeChar('A');

            System.out.println("데이터를 '" + filename + "' 파일에 성공적으로 저장했습니다.");
        } catch (IOException e) {
            System.err.println("데이터 쓰기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n---------------------------------------\n");

        // 2. DataInputStream을 사용하여 데이터 읽기
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {

            System.out.println("'" + filename + "'  파일에서 데이터 읽기:");

            int intValue = dis.readInt();
            double doubleValue = dis.readDouble();
            boolean booleanValue = dis.readBoolean();
            String stringValue = dis.readUTF();
            char charValue = dis.readChar();

            System.out.println("읽은 정수: " + intValue);
            System.out.println("읽은 실수: " + doubleValue);
            System.out.println("읽은 불리언: " + booleanValue);
            System.out.println("읽은 문자열: " + stringValue);
            System.out.println("읽은 문자: " + charValue);

            // 만약 더 읽으려고 하면 EOFException 발생 가능
            // dis.readInt(); // 주석 해제 시 EOFException 발생 가능성 높음
        } catch (EOFException e) {
            System.err.println("파일의 끝에 도달했습니다. 더 이상 읽을 데이터가 없습니다.");
        } catch (FileNotFoundException e) {
            System.err.println("오류:  파일 '" + filename + "' 을(를)  찾을 수 없습니다");
        } catch (IOException e) {
            System.out.println("데이터 읽기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}