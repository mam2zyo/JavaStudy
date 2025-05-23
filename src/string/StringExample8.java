package string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringExample8 {
    public static void main(String[] args) {
        // 1. Base64 ENCODING / DECODING
        String originalText = "안녕하세요! Hello World! 123";

        // Base64 ENCODING
        String encodedBase64 = Base64.getEncoder().encodeToString(
                originalText.getBytes(StandardCharsets.UTF_8)
        );

        // Base64 DECODING
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBase64);
        String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("Base64 디코딩: " + decodedText);

        // 2. URL ENCODING / DECODING
        String url = "https://example.com/search?q=자바 프로그래밍&page=1";

        try {
            String encodedUrl = URLEncoder.encode(url, "UTF-8");
            System.out.println("\nURL 인코딩: " + encodedUrl);

            String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");
            System.out.println("URL 디코딩: " + decodedUrl);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 3. 문자열 바이트 변환
        String koreanText = "한글 텍스트";

        // UTF-8 바이트 배열로 변환
        byte[] utf8Bytes = koreanText.getBytes(StandardCharsets.UTF_8);
        System.out.println("\nUTF-8 바이트 길이: " + utf8Bytes.length);

        // 바이트 배열을 16진수 문자열로 변환
        StringBuilder hexString = new StringBuilder();
        for (byte b : utf8Bytes) {
            hexString.append(String.format("%02x ", b));
        }
        System.out.println("16진수 표현: " + hexString.toString().trim());

        // 바이트 배열에서 문자열로 복원
        String restoredText = new String(utf8Bytes, StandardCharsets.UTF_8);
        System.out.println("복원된 텍스트: " + restoredText);

        // 4. 특수 문자 이스케이프
        String jsonString = "{" +
                "\"name\": \"홍길동\"," +
                "\"message\": \"안녕하세요!\\n반갑습니다.\" }";
        System.out.println("\nJSON 문자열: " + jsonString);

        // 특수 문자 이스케이프 해제 (단순한 예)
        String unescapedJson = jsonString.replace("\\n", "\n")
                .replace("\\\"", "\"");
        System.out.println("이스케이프 해제: " + unescapedJson);

        // 5. 문자열 해시 생성 (단순한 해시)
        String text = "Hello World";
        int hashCode = text.hashCode();
        System.out.println("\n문자열 해시코드: " + hashCode);

        // 각 문자의 ASCII 값 합계로 간단한 해시 생성
        int customHash = 0;
        for (char c : text.toCharArray()) {
            customHash += (int) c;
        }
        System.out.println("Custom Hash: " + customHash);
    }
}