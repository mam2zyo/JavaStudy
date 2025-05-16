package string;

public class StringExample4 {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = new String("Hello");

        // 1. 문자열 비교 (==, equals)
        System.out.println("str1 == str2: " + (str1 == str2));  // false (대소문자 다름)
        System.out.println("str1 == str3: " + (str1 == str3));  // false (다른 객체)
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // false (대소문자 다름)
        System.out.println("str1.equals(str3): " + str1.equals(str3));  // true (내용 같음)

        // 2. 대소문자 무시하고 비교
        System.out.println("str1.equalsIgnoreCase(str2): " + str1.equalsIgnoreCase(str2));  // true

        // 3. 사전식 순서 비교
        System.out.println("str1.compareTo(str2): " + str1.compareTo(str2));  // 음수 ('H'가 'h'보다 ASCII 값이 작음)
        System.out.println("str2.compareTo(str1): " + str2.compareTo(str1));  // 양수

        // 4. 문자열 검색 (정규식 활용)
        String text = "Contact: john@example.com, mary@test.com";
        String emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        // 패턴 객체 생성
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcher = pattern.matcher(text);

        System.out.println("\n이메일 주소 추출:");
        // 일치하는 모든 부분 찾기
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}