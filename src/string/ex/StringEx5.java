package string.ex;

/*
 주어진 CSV 형식의 데이터에서 각 필드를 추출하고,
 사용자 정보를 형식화하여 출력하는 프로그램을 작성하세요.
 각 사용자에 대해
 "이름: [이름], 나이: [나이]세, 이메일: [이메일]" 형식으로 출력하고,
 마지막에 사용자의 평균 나이를 소수점 첫째 자리까지 출력하세요.

 입력 예:
 String csvData = "John,25,john@example.com\n" +
        "Sarah,31,sarah@example.com\n" +
        "Mike,18,mike@example.com\n" +
        "Lisa,42,lisa@example.com";

 출력 예:
 사용자 1: 이름: John, 나이: 25세, 이메일: john@example.com
 사용자 2: 이름: Sarah, 나이: 31세, 이메일: sarah@example.com
 사용자 3: 이름: Mike, 나이: 18세, 이메일: mike@example.com
 사용자 4: 이름: Lisa, 나이: 42세, 이메일: lisa@example.com
 평균 나이: 29.0세
*/

public class StringEx5 {
    public static void main(String[] args) {

        String csvData = "John,25,john@example.com\n" +
                "Sarah,31,sarah@example.com\n" +
                "Mike,18,mike@example.com\n" +
                "Lisa,42,lisa@example.com";

        String[] users = csvData.split("\n");
        int totalAge = 0;

        for (int i = 0; i < users.length; i++) {
            String[] userData = users[i].split(",");
            String name = userData[0];
            int age = Integer.parseInt(userData[1]);
            String email = userData[2];

            // 사용자 정보 출력
            System.out.printf("사용자 %d: 이름: %s, 나이: %d세, 이메일: %s\n",
                    i + 1, name, age, email);

            totalAge += age;
        }

        // 평균 나이 계산 및 출력
        double averageAge = (double) totalAge / users.length;
        System.out.printf("평균 나이: %.1f세", averageAge);
    }
}