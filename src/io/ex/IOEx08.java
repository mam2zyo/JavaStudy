package io.ex;

/*
    Java I/O 복습 문제 1: 개인 연락처 관리 프로그램 (파일 입출력 종합)

    목표: 지금까지 배운 Scanner, FileWriter/FileReader, BufferedWriter/BufferedReader,
    그리고 객체 직렬화(ObjectOutputStream/ObjectInputStream) 개념을 활용하여 간단한
    개인 연락처 관리 프로그램을 만들어 봅니다.

    요구사항:

    1. Contact 클래스 정의:
        * 필드: name (String), phoneNumber (String), email (String, 선택 사항이므로 null 가능),
          memo (String, transient로 선언, 직렬화 제외)
        * java.io.Serializable 인터페이스를 구현하고, serialVersionUID를 적절히 설정합니다.
        * 생성자, Getter/Setter (필요시), toString() 메소드를 보기 좋게 만듭니다.
          (memo는 toString에 포함시키되, 역직렬화 시 null일 수 있음을 고려)

    2. 프로그램 주요 기능:
        * 연락처 추가: 사용자로부터 이름, 전화번호, 이메일(선택), 메모(선택)를 입력받아 Contact 객체를
          생성하고, 이를 리스트에 추가합니다.
        * 연락처 목록 보기: 현재 메모리에 있는 모든 연락처 정보를 출력합니다.
        * 연락처 파일로 저장: 현재 메모리에 있는 연락처 리스트(List<Contact>)를 "contacts.dat"
          파일에 객체 직렬화하여 저장합니다.
        * ObjectOutputStream과 BufferedOutputStream을 사용합니다.
        * 연락처 파일에서 불러오기: "contacts.dat" 파일에서 연락처 리스트를 객체 역직렬화하여 메모리로
          불러옵니다. 프로그램 시작 시 자동으로 이 파일을 읽어오도록 합니다. 파일이 없으면 빈 리스트로 시작합니다.
        * ObjectInputStream과 BufferedInputStream을 사용합니다.
        * 연락처 텍스트 파일로 내보내기 (Export): 현재 메모리에 있는 모든 연락처 정보를
          "contacts_export.txt" 텍스트 파일로 저장합니다. 각 연락처 정보는 한 줄에 알아보기 쉽게 표현하고,
          각 연락처 사이는 빈 줄 등으로 구분합니다.
        * BufferedWriter와 FileWriter를 사용합니다. Contact 객체의 toString() 메소드를 활용할 수 있습니다.
        * 프로그램 종료: 종료 시 현재 메모리의 연락처를 "contacts.dat"에 자동 저장하는 옵션을 고려해볼 수 있습니다 (필수 아님).

    3. 사용자 인터페이스 (콘솔 기반):
        * Scanner를 사용하여 사용자로부터 메뉴 선택 및 정보를 입력받습니다.
        * 메인 루프를 만들어 사용자가 "종료"를 선택할 때까지 기능을 반복적으로 제공합니다.

    4. 구현 세부 사항:
        * 연락처 데이터는 ArrayList<Contact>를 사용하여 메모리에서 관리합니다.
        * 모든 파일 I/O 작업은 try-with-resources를 사용하고, 적절한 예외 처리(FileNotFoundException,
          IOException, ClassNotFoundException 등)를 포함해야 합니다.
        * 각 기능은 별도의 메소드로 분리하여 코드의 가독성과 유지보수성을 높입니다.


    실행 흐름 예시:

        연락처 관리 프로그램
        --------------------
        1. 연락처 추가
        2. 연락처 목록 보기
        3. 연락처 파일로 저장
        4. 연락처 파일에서 불러오기 (프로그램 시작 시 자동 로드)
        5. 연락처 텍스트 파일로 내보내기
        0. 종료
        --------------------
        메뉴를 선택하세요: 4 (프로그램 시작 시 이미 로드되었다고 가정)

        메뉴를 선택하세요: 1
        이름: 홍길동
        전화번호: 010-1234-5678
        이메일 (없으면 Enter): gildong@example.com
        메모 (없으면 Enter): 친구
        연락처가 추가되었습니다.

        메뉴를 선택하세요: 2
        [연락처 목록]
        1. 이름: 홍길동, 전화번호: 010-1234-5678, 이메일: gildong@example.com, 메모: (메모리에 있을 때만 보임)
        ... (다른 연락처들) ...

        메뉴를 선택하세요: 5
        contacts_export.txt 파일로 내보냈습니다.

        메뉴를 선택하세요: 0
        프로그램을 종료합니다. (자동 저장 여부 메시지)


    도전 과제 (선택 사항):
        * 연락처 검색 기능 추가
        * 연락처 수정/삭제 기능 추가
        * memo 필드도 직렬화/역직렬화에 포함시키되, 사용자가 원할 경우에만 직렬화하도록 옵션 제공
          (예: writeObject 커스터마이징 또는 별도 필드 사용)
*/


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@AllArgsConstructor
class Contact implements Serializable {
    private final String name;
    private final String phoneNumber;
    @Setter
    private String email;
    @Setter
    transient private String memo;

    @Serial
    private static final long serialVersionUID = 20250526L;

    public Contact (String name, String number) {
        this.name = name;
        this.phoneNumber = number;
    }

    public Contact (String name, String number, String email) {
        this.name = name;
        this.phoneNumber = number;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("이름: %s, 전화번호: %s, 이메일: %s, 메모: %s",
                name, phoneNumber, email == null ? "" : email, memo == null ? "null" : memo);
    }
}



public class IOEx08 {
    private static List<Contact> contacts = new ArrayList<>();
    private static String filename = "contacts.dat";
    private static String exportedTextFile = "contacts_export.txt";

    public static void addContact(Scanner scanner) {

        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String number = scanner.nextLine();
        System.out.print("이메일 (없으면 Enter): ");
        String email = scanner.nextLine();
        System.out.print("메모 (없으면 Enter): ");
        String memo = scanner.nextLine();

        if (name.isBlank() || number.isBlank()) {
            System.out.println("이름과 전화번호는 공백일 수 없습니다.");
            return;
        }

        if (memo.isBlank()) {
            if (email.isBlank()) {
                contacts.add(new Contact(name, number));
            } else {
                contacts.add(new Contact(name, number, email));
            }
        } else {
            if (email.isBlank()) {
                contacts.add(new Contact(name, number, "", memo));
            } else {
                contacts.add(new Contact(name, number, email, memo));
            }
        }
        System.out.println("연락처가 추가되었습니다.");
    }

    public static void showContacts() {

        if (contacts.isEmpty()) {
            System.out.println("연락처가 비어있습니다.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    public static boolean serializeContacts() {
        try (FileOutputStream fos = new FileOutputStream(filename);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {

            oos.writeObject(contacts);

            System.out.println("연락처를 '" + filename + "' 파일에" +
                    "성공적으로 저장했습니다.");

            return true;

        } catch (IOException e) {
            System.err.println("객체 직렬화 중 오류: " + e.getMessage());
            throw new RuntimeException("객체를 파일에 쓰는 중 오류");
        }
    }


    public static boolean deserializeContacts() {
        try (FileInputStream fis = new FileInputStream(filename);
             BufferedInputStream bis = new BufferedInputStream(fis);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            contacts = (List<Contact>) ois.readObject();
            System.out.println("'" + filename + "' 파일에서 연락처를 메모리에 로드했습니다.");
            return true;

        } catch (FileNotFoundException e) {
            System.err.println(filename + "을(를) 찾을 수 없습니다." + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("클래스를 찾을 수 없습니다." + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("역직렬화 중 오류: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public static boolean exportContactsToText() {
        try (FileWriter fw = new FileWriter(exportedTextFile);
             BufferedWriter bw = new BufferedWriter(fw)) {

            for (Contact contact : contacts) {
                bw.write(contact.toString());     // 문자열 쓰기
                bw.newLine();       // 새 줄 문자 쓰기 (플랫폼 독립적)
            }

            System.out.println("연락처를 " + exportedTextFile + "파일로 내보내기 성공");
            return true;

        } catch (IOException e) {
            System.err.println("파일 쓰기 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("연락처 관리 프로그램");
            System.out.println("--------------------");
            System.out.println("1. 연락처 추가");
            System.out.println("2. 연락처 목록 보기");
            System.out.println("3. 연락처 파일로 저장");
            System.out.println("4. 연락처 파일에서 불러오기");
            System.out.println("5. 연락처 텍스트 파일로 내보내기");
            System.out.println("0. 종료");
            System.out.println("--------------------");
            System.out.print("메뉴를 선택하세요: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addContact(scanner);
                    break;

                case 2:
                    showContacts();
                    break;

                case 3:
                    serializeContacts();
                    break;

                case 4:
                    deserializeContacts();
                    break;

                case 5:
                    exportContactsToText();
                    break;

                case 0:
                    serializeContacts();
                    scanner.close();
                    return;

                default:
                    System.out.println("번호 입력 오류");

            }
        }
    }
}