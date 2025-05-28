package string;

import java.util.StringJoiner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringExample9 {
    public static void main(String[] args) {
        // 1. 문자열 풀(String Pool) 이해
        String str1 = "Hello";           // 문자열 풀에 저장
        String str2 = "Hello";           // 기존 풀에서 참조
        String str3 = new String("Hello"); // 힙에 새로운 객체 생성

        System.out.println("=== 문자열 풀 테스트 ===");
        System.out.println("str1 == str2: " + (str1 == str2));         // true
        System.out.println("str1 == str3: " + (str1 == str3));         // false
        System.out.println("str1.equals(str3): " + str1.equals(str3)); // true

        // intern() 메소드 사용
        String str4 = str3.intern(); // 문자열 풀에서 찾거나 추가
        System.out.println("str1 == str4: " + (str1 == str4));         // true

        // 2. StringJoiner 사용 (효율적인 문자열 결합)
        System.out.println("\n=== StringJoiner 사용 ===");
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("사과");
        joiner.add("바나나");
        joiner.add("오렌지");
        System.out.println("StringJoiner 결과: " + joiner.toString());

        // 빈 StringJoiner 처리
        StringJoiner emptyJoiner = new StringJoiner(", ", "[", "]");
        emptyJoiner.setEmptyValue("비어있음");
        System.out.println("빈 StringJoiner: " + emptyJoiner.toString());

        // 3. String.join() 메소드 (Java 8+)
        System.out.println("\n=== String.join() 사용 ===");
        List<String> fruits = Arrays.asList("딸기", "포도", "수박");
        String joined = String.join(" | ", fruits);
        System.out.println("String.join 결과: " + joined);

        // 배열과 함께 사용
        String[] colors = {"빨강", "파랑", "노랑"};
        String colorString = String.join("-", colors);
        System.out.println("배열 join 결과: " + colorString);

        // 4. 성능 비교 테스트
        System.out.println("\n=== 성능 비교 테스트 ===");
        int iterations = 10000;

        // String 연결 (+) - 비효율적
        long startTime = System.nanoTime();
        String result1 = "";
        for (int i = 0; i < iterations; i++) {
            result1 += "test";
        }
        long endTime = System.nanoTime();
        System.out.println("String + 연산 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // StringBuilder - 효율적
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("test");
        }
        String result2 = sb.toString();
        endTime = System.nanoTime();
        System.out.println("StringBuilder 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // StringJoiner - 구분자가 있는 경우 효율적
        startTime = System.nanoTime();
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < iterations; i++) {
            sj.add("test");
        }
        String result3 = sj.toString();
        endTime = System.nanoTime();
        System.out.println("StringJoiner 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");

        // 5. 메모리 효율적인 문자열 처리
        System.out.println("\n=== 메모리 효율적인 처리 ===");
        String largeText = "This is a very long text that we want to process efficiently...";

        // substring()의 메모리 특성 (Java 7 이후)
        String sub1 = largeText.substring(0, 10);
        System.out.println("Substring: " + sub1);

        // 대용량 텍스트 처리 시 고려사항
        StringBuilder efficientBuilder = new StringBuilder(1000); // 초기 용량 설정
        for (int i = 0; i < 100; i++) {
            efficientBuilder.append("Data ").append(i).append("; ");
        }

        // 6. Stream을 이용한 문자열 처리
        System.out.println("\n=== Stream을 이용한 처리 ===");
        List<String> words = Arrays.asList("Java", "is", "awesome", "for", "string", "processing");

        // 대문자로 변환하고 길이가 4 이상인 단어만 결합
        String processed = words.stream()
                .filter(word -> word.length() >= 4)
                .map(String::toUpperCase)
                .collect(Collectors.joining(" - "));

        System.out.println("Stream 처리 결과: " + processed);

        // 7. 문자열 캐싱 예제
        System.out.println("\n=== 문자열 캐싱 ===");
        demonstrateStringCaching();
    }

    // 문자열 캐싱 데모
    private static void demonstrateStringCaching() {
        // 자주 사용되는 문자열은 상수로 정의
        final String SEPARATOR = " | ";
        final String PREFIX = "[INFO] ";

        StringBuilder cachedBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            cachedBuilder.append(PREFIX)
                    .append("메시지 ")
                    .append(i)
                    .append(SEPARATOR);
        }

        System.out.println("캐싱된 상수 사용: " + cachedBuilder.toString());
    }
}