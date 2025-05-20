package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExample7 {
    public static void main(String[] args) {
        // 1. 정규 표현식 패턴 생성
        Pattern pattern = Pattern.compile(
                "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");

        // 2. 텍스트에서 이메일 주소 찾기
        String text = "연락처: john.doe@example.com, mary.smith@company.co.kr, invalid@email";
        Matcher matcher = pattern.matcher(text);

        System.out.println("이메일 주소 찾기:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        // 3. 문자열 검증
        String email1 = "test@example.com";
        String email2 = "invalid-email";

        System.out.println("\n이메일 형식 검증:");
        System.out.println(email1 + " 유효성: " + Pattern.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email1));
        System.out.println(email2 + " 유효성: " + Pattern.matches(
                "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email2));

        // 4. 문자열 치환
        String phoneNumber = "전화번호는 010-1234-5678입니다. 또는 02-987-6543으로 연락하세요";
        String maskedPhoneNumber = phoneNumber.replaceAll(
                "(\\d{2,3})-(\\d{3,4})-(\\d{4})", "$1-****-$3");
        System.out.println("\n전화번호 마스킹:");
        System.out.println("원본: " + phoneNumber);
        System.out.println("마스킹: " + maskedPhoneNumber);

        // 5. 문자열 분할
        String csvData = "홍길동,25,서울,개발자";
        String[] parts = csvData.split(",");

        System.out.println("\nCSV 데이터 분할:");
        for (int i = 0; i < parts.length; i++) {
            System.out.println("항목: " + (i + 1) + ": " + parts[i]);
        }

        // 6. 그룹 캡처
        String html = "<div>제목: <h1>자바 프로그래밍</h1></div><p>Java는 객체지향 프로그래명 언어입니다.</p>";
        Pattern headerPattern = Pattern.compile("<h1>(.*?)</h1>");
        Matcher headerMatcher = headerPattern.matcher(html);

        System.out.println("\nHTML 헤더 추출:");
        if (headerMatcher.find()) {
            System.out.println("추출된 제목: " + headerMatcher.group(1));
        }
    }
}