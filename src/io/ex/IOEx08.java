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

import java.io.Serial;
import java.io.Serializable;

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
                name, phoneNumber, email == null ? "" : email, memo == null ? "" : memo);
    }
}



public class IOEx08 {


    public static void main(String[] args) {


    }
}