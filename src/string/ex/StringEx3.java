package string.ex;

// 주어진 이메일 주소 목록에서 '@' 이후의 도메인 부분만 추출하여
// 중복 없이 알파벳 순으로 정렬하여 출력하는 프로그램을 작성하세요.

// 입력 예:
// String[] emails = {
//        "user1@gmail.com",
//        "user2@yahoo.com",
//        "user3@gmail.com",
//        "user4@hotmail.com",
//        "user5@gmail.com",
//        "user6@yahoo.com" };

// 출력 예:
// 도메인 목록:
// - gmail.com
// - hotmail.com
// - yahoo.com

import java.util.Set;
import java.util.TreeSet;

public class StringEx3 {
    public static void main(String[] args) {
        String[] emails = {
                "user1@gmail.com",
                "user2@yahoo.com",
                "user3@gmail.com",
                "user4@hotmail.com",
                "user5@gmail.com",
                "user6@yahoo.com"
        };

        Set<String> domains = new TreeSet<>();

        for (String email : emails) {
            String domain = email.substring(email.indexOf('@') + 1);
            domains.add(domain);
        }

//        for (String email : emails) {
//            String[] temp = new String[2];
//            temp = email.split("@");
//            domains.add(temp[1]);
//        }

        for (String domain :domains) {
            System.out.println("- " + domain);
        }
    }
}