package string;

public class StringExample3 {
    public static void main(String[] args) {
        String sentence = "Java,Python,C++,JavaScript,Ruby";

        // 1. 문자열 분할하기
        String[] languages = sentence.split(",");
        System.out.println("프로그래밍 언어 목록:");
        for (String language : languages) {
            System.out.println("- " + language);
        }

        // 2. 문자열 배열 결합하기
        String joined = String.join(" | ", languages);
        System.out.println("\n결합된 문자열: " + joined);

        // 3. 문자열 앞뒤 공백 제거
        String textWithSpaces = "   Trim example   ";
        System.out.println("원본: '" + textWithSpaces + "'");
        System.out.println("trim 적용: '" + textWithSpaces.trim() + "'");

        // 4. 문자열이 비어있는지 확인
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("빈 문자열인가? " + emptyStr.isEmpty());
        System.out.println("공백만 있는 문자열이 빈 문자열인가? " + blankStr.isEmpty());
        // Java 11 이상에서는 isBlank() 메소드도 사용 가능
        // System.out.println("공백만 있는 문자열이 blank인가? " + blankStr.isBlank());
    }
}