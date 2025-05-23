package string.ex;

/*
    주어진 문자열이 Base64로 인코딩된 JSON 데이터라고 가정하고,
    이를 디코딩한 후 JSON에서 특정 값을 추출하는 프로그램을 작성하세요.
    (JSON 파싱 라이브러리 없이 문자열 조작만으로 해결하세요)

    조건:
    Base64 디코딩을 수행하세요
    디코딩된 JSON에서 "name"과 "age" 필드의 값을 추출하세요
    추출할 때 따옴표를 제거하고 순수한 값만 출력하세요

    입력 예:
    String encodedJson = "eyJuYW1lIjoi7ZmN6ri464+ZIiwiYWdlIjoyNSwiY2l0eSI6IuyEnOyauCJ9";

    예상 출력:
    디코딩된 JSON: {"name":"홍길동","age":25,"city":"서울"}
    name: 홍길동
    age: 25
*/

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class StringEx8 {

    static String getValue(String[] pairs, String key) {

        String value = "";

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2 && keyValue[0].trim().equals(key)) {
                value = keyValue[1].trim();
            }
        }
        return value;
    }


    public static void main(String[] args) {
        String encodedJson = "eyJuYW1lIjoi7ZmN6ri464+ZIiwiYWdlIjoyNSwiY2l0eSI6IuyEnOyauCJ9";

        byte[] decodedBytes = Base64.getDecoder().decode(encodedJson);
        String decodedText = new String(decodedBytes, StandardCharsets.UTF_8);
        System.out.println("디코딩된 JSON: " + decodedText);

        String stripped = decodedText.replace("{", "")
                .replace("}", "")
                .replace("\"", "");

        String[] pairs = stripped.split(",");

        System.out.println("name: " + getValue(pairs, "name"));
        System.out.println("age: " + getValue(pairs, "age"));
    }
}