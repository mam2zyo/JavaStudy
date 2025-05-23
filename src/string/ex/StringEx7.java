package string.ex;

/*
주어진 텍스트에서 유효한 한국 휴대폰 번호를 모두 찾아서 출력하는 프로그램을
작성하세요. 한국 휴대폰 번호 형식은 '010-XXXX-XXXX' 또는 '010XXXXXXXX'
또는 '010 XXXX XXXX'로 가정합니다. 정규 표현식을 사용하여 해결하세요.

입력 예:

String text = "안녕하세요, 제 번호는 010-1234-5678이고, 친구 번호는 01098765432입니다. " +
        "다른 친구는 010 8765 4321, 그리고 01-1234-5678, 010-123-4567 등의 번호를 사용합니다.";


출력 예:

찾은 휴대폰 번호:
010-1234-5678
01098765432
010 8765 4321
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEx7 {
    public static void main(String[] args) {

        String text = "안녕하세요, 제 번호는 010-1234-5678이고, 친구 번호는 01098765432입니다. " +
                "다른 친구는 010 8765 4321, 그리고 01-1234-5678, 010-123-4567 등의 번호를 사용합니다.";

        Pattern pattern = Pattern.compile("010(-\\d{4}-\\d{4}|\\d{8}| \\d{4} \\d{4})");
        Matcher matcher = pattern.matcher(text);

        // Pattern pattern = Pattern.compile("010(|-| )\\d{4}(|-| )\\d{4}");
        // 010-1234 6486 << 이런 형태도 가능

        System.out.println("찾은 휴대폰 번호:");
        while (matcher.find()) {
            System.out.println(matcher.group()); //
        }
    }
}