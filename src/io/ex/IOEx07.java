package io.ex;

/*
    1. Book 클래스를 정의합니다.
        * 필드: title (String), author (String), price (int),
          isbn (String, 직렬화 제외 대상 - transient 사용).
        * Serializable 인터페이스를 구현하고, serialVersionUID를 적절히 설정합니다.
        * 생성자와 toString() 메소드를 보기 좋게 만듭니다.

    2. 여러 개의 Book 객체를 생성하여 ArrayList<Book>에 저장합니다.

    3. 이 ArrayList<Book> 객체를 "books.ser" (또는 "books.dat") 파일에
       직렬화하여 저장합니다.
        * ObjectOutputStream을 사용하고, 성능 향상을 위해
          BufferedOutputStream을 함께 사용하세요.

    4. 파일 저장이 완료되면, 저장된 "books.ser" 파일의 내용을 다시 읽어와
       ArrayList<Book> 객체로 역직렬화합니다.
        * ObjectInputStream을 사용하고, 성능 향상을 위해 BufferedInputStream을 함께 사용하세요.

    5. 역직렬화된 Book 객체들의 정보를 콘솔에 출력합니다.
       (isbn 필드는 기본값으로 출력될 것입니다.)

    6. 모든 I/O 스트림은 try-with-resources를 사용하고, 적절한 예외 처리(FileNotFoundException,
       IOException, ClassNotFoundException)를 포함하세요.
*/

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
class Book implements Serializable {

    private static final long serialVersionUID = 20250523L;

    String title;
    String author;
    int price;
    transient String isbn;

    @Override
    public String toString() {
        return String.format("제목: %s, 저자: %s, 가격: %d, ISBN: %s",
        title, author, price, (isbn == null ? "N/A" : isbn));
    }
}

public class IOEx07 {

    static void serializeBooks(List<Book> bookList, String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(bookList);
            System.out.println("도서 객체를 성공적으로 파일에 직렬화했습니다.");

        } catch (IOException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    static void deserializeBooks(String filename) {

        List<Book> deserializedBookList = null;

        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            deserializedBookList = (List<Book>) ois.readObject();

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("파일 읽기 오류" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("역직렬화 파일 내용:");
        for (Book book : deserializedBookList) {
            System.out.println(book);
        }
    }


    public static void main(String[] args) {
        String filename = "books.ser";

        List<Book> bookList = new ArrayList<>();

        Book book1 = new Book("자바의 정석", "남궁성", 30000, "9788994492032");
        Book book2 = new Book("Do it! 자바 프로그래밍 입문", "박은종", 22500, "9791163031735");
        Book book3 = new Book("혼자 공부하는 자바", "신용권", 27000, "9791162241875");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        serializeBooks(bookList,filename);

        deserializeBooks(filename);
    }
}