package string;

public class StringExample1 {
    public static void main(String[] args) {
        // 문자열 생성
        String greeting = "Hello, World!";

        // 1. 문자열 길이 구하기
        int length = greeting.length();
        System.out.println("문자열 길이: " + length);

        // 2. 특정 위치의 문자 가져오기
        char firstChar = greeting.charAt(0);
        System.out.println("첫 번째 문자: " + firstChar);

        // 3. 부분 문자열 추출하기
        String subStr = greeting.substring(0, 5); // 0부터 5 이전까지 (Hello)
        System.out.println("부분 문자열: " + subStr);

        // 4. 대소문자 변환
        String lowerCase = greeting.toLowerCase();
        String upperCase = greeting.toUpperCase();
        System.out.println("소문자: " + lowerCase);
        System.out.println("대문자: " + upperCase);

        // 5. 문자열 포함 여부 확인
        boolean containsWorld = greeting.contains("World");
        System.out.println("'World' 포함 여부: " + containsWorld);
    }
}
