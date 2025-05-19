package string.ex;

/*
여러 단어가 주어졌을 때, 각 단어의 첫 글자만 대문자로 바꾸고 나머지는 소문자로 바꾸는
프로그램을 작성하세요. 단, StringBuilder를 사용하고 원본 문자열을 수정하지 마세요.

입력 예:
String[] words = {"java", "PYTHON", "JavaScript", "c++", "rUbY"};

출력 예:
원본 배열: [java, PYTHON, JavaScript, c++, rUbY]
변환 결과: [Java, Python, Javascript, C++, Ruby]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringEx6 {
    public static void main(String[] args) {
        String[] words = {"java", "PYTHON", "JavaScript", "c++", "rUbY"};

        List<String> origin = Arrays.asList(words);
        List<String> target = new ArrayList<>();

        origin.stream()
                .map(String::toLowerCase)
                .map(word -> Character.toUpperCase(word.charAt(0)) +
                        word.substring(1))
                .forEach(target::add);

        System.out.println("원본 배열: " + origin);
        System.out.println("변환 결과: " + target);
    }
}