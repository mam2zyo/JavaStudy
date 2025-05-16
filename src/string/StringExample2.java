package string;

public class StringExample2 {
    public static void main(String[] args) {
        String text = "Java programming is fun. Java is versatile.";

        // 1. 특정 문자열의 첫 등장 위치 찾기
        int firstIndex = text.indexOf("Java");
        System.out.println("'Java'의 첫 등장 위치: " + firstIndex);

        // 2. 특정 문자열의 마지막 등장 위치 찾기
        int lastIndex = text.lastIndexOf("Java");
        System.out.println("'Java'의 마지막 등장 위치: " + lastIndex);

        // 3. 문자열 치환하기
        String replaced = text.replace("Java", "Python");
        System.out.println("치환 결과: " + replaced);

        // 4. 정규식을 이용한 치환
        String regex = text.replaceAll("\\s+", "-");
        System.out.println("정규식 치환 결과: " + regex);

        // 5. 문자열 시작과 끝 확인
        boolean startsWithJava = text.startsWith("Java");
        boolean endsWithDot = text.endsWith(".");
        System.out.println("'Java'로 시작하는가? " + startsWithJava);
        System.out.println("'.'으로 끝나는가? " + endsWithDot);
    }
}