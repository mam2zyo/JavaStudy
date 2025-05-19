package string;

public class StringExample6 {
    public static void main(String[] args) {
        // 1. String 연결(concat by +) 시 속도 측정
        long startTime = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("String 연결 시간: " + (endTime - startTime) + "ms");

        // 2. Stringbuilder 사용시 속도 측정
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("a");
        }
        result = sb.toString();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 시간: " + (endTime - startTime) + "ms");

        // 3. StringBuffer 사용시(다중 쓰레드 환경에 안전)
        startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            buffer.append("a");
        }
        result = buffer.toString();
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 시간: " + (endTime - startTime) + "ms");

        // 4. 다양한 메서드
        StringBuilder builder = new StringBuilder("Hello, World!");

        builder.insert(7, "Beautiful ");
        System.out.println(builder);

        builder.delete(7, 17);
        System.out.println(builder);

        builder.reverse();
        System.out.println(builder);

        builder.setCharAt(0, '?');
        System.out.println(builder);

        StringBuilder sb2 = new StringBuilder(100);
        System.out.println("초기 용량: " + sb2.capacity());
    }
}