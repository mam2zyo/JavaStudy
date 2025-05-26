package io.ex;

/*
    다음 요구사항을 만족하는 Java 프로그램을 작성해 보세요.

    1. 학생 정보 (이름, 나이, 평균 학점) 를 표현하는
       간단한 데이터 세트를 준비합니다. (예: 3명의 학생 정보)
        * 이름: String
        * 나이: int
        * 평균 학점: double

    2. 이 학생 정보들을 "students.dat" 라는 파일에 저장합니다.
        * DataOutputStream을 사용합니다.
        * 성능 향상을 위해 BufferedOutputStream을 함께 사용하세요.
        * 먼저 학생의 수(정수)를 파일에 기록하고, 그 다음에 각 학생의 이름, 나이, 학점을
          순서대로 기록합니다. (이렇게 하면 나중에 몇 명의 학생 정보를 읽어야 할지 알 수 있습니다.)

    3. 파일 저장이 완료되면, 저장된 "students.dat" 파일의 내용을 다시 읽어와
       콘솔에 각 학생의 정보를 출력합니다.
        * DataInputStream을 사용합니다.
        * 성능 향상을 위해 BufferedInputStream을 함께 사용하세요.
        * 먼저 학생 수를 읽고, 그 수만큼 반복하면서 각 학생의 이름, 나이, 학점을 읽어와 출력합니다.

    4. 모든 I/O 스트림은 try-with-resources를 사용하고,
       적절한 예외 처리(EOFException, FileNotFoundException, IOException)를 포함하세요.
*/

import lombok.AllArgsConstructor;
import java.io.*;

@AllArgsConstructor
class Student {
    String name;
    int age;
    double grade;

    @Override
    public String toString() {
        return String.format("이름: %s, 나이: %d, 평균 학점: %.1f", name, age, grade);
    }
}

public class IOEx06 {

    static void writeStudentInfo(String filename, Student[] students) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos)) {

            dos.writeInt(students.length);

            for (Student student : students) {
                dos.writeUTF(student.name);
                dos.writeInt(student.age);
                dos.writeDouble(student.grade);
            }

        } catch (IOException e) {
            System.err.println("쓰기 오류 발생" + e.getMessage());
            e.printStackTrace();
        }
    }

    static void readStudentInfo(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis)) {

            int count = dis.readInt();      // 저장된 학생 수 읽기

            Student[] students = new Student[count];

            for (int i = 0; i < count; i++) {
                String name  = dis.readUTF();
                int age = dis.readInt();
                double grade = dis.readDouble();

                students[i] = new Student(name, age, grade);
            }

            for (Student student : students) {
                System.out.println(student);
            }

        } catch (EOFException e) {
            System.err.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다." + e.getMessage());
        } catch (IOException e) {
            System.err.println("읽기 오류" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "students.dat";

        Student[] students = {
                new Student("홍길동", 22, 98.21),
                new Student("Jane", 52, 77.21),
                new Student("한석봉", 34, 43.55)
        };

        writeStudentInfo(filename, students);
        readStudentInfo(filename);
    }
}