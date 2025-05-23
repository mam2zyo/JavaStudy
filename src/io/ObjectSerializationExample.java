package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectSerializationExample {

    static void serializeObject(String filename) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(
                new Student("고길동", 45, 75.5, "둘리 때문에 힘듦")
        );
        studentList.add(
                new Student("마이콜", 23, 88.0, "가수 지망생")
        );
        studentList.add(
                new Student("희동이", 3, 95.0, "응애")
        );

        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(studentList);

            System.out.println("학생 객체 리스트를 '" + filename + "' 파일에" +
                    "성공적으로 직렬화했습니다.");

        } catch (IOException e) {
            System.err.println("객체 직렬화 중 오류: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void deSerializeObject(String filename) {

        List<Student> deserializedList = null;

        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            deserializedList = (List<Student>) ois.readObject();

            System.out.println("'" + filename + "' 파일에서 학생 객체 리스트를 성공적으로 역직렬화했습니다.");

        } catch (FileNotFoundException e) {
            System.err.println(filename + "을(를) 찾을 수 없습니다.");
        } catch (IOException e) {
            System.err.println("역직렬화 중 오류: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("클래스를 찾을 수 없습니다.");
            e.printStackTrace();
        }

        if (deserializedList != null) {
            for (Student student : deserializedList) {
                System.out.println(student);
            }
        }
    }


    public static void main(String[] args) {
        String filename = "students_objects.dat";

        serializeObject(filename);

        deSerializeObject(filename);
    }
}