package string.ex;

/*
    문자열 분석 도구 만들기
    사용자가 입력한 텍스트에 대해 다음과 같은 분석을 수행하는 프로그램을 작성하세요:

    기본 통계: 전체 문자 수, 단어 수, 문장 수
    문자 분석: 가장 많이 사용된 문자 3개 (공백 제외)
    단어 분석: 가장 긴 단어, 가장 짧은 단어
    특별 검사: 회문인 단어가 있는지 확인
    결과 포맷팅: StringBuilder를 사용하여 보고서 형태로 출력

    입력 예:
    javaString text = "Java is a powerful programming language. " +
            "Programming with Java is fun and level up your skills. " +
            "A good programmer never stops learning.";

    예상 출력 형태:
    === 문자열 분석 보고서 ===
    총 문자 수: 123
    총 단어 수: 18
    총 문장 수: 3

    가장 많이 사용된 문자:
    1. 'a' (12회)
    2. 'r' (10회)
    3. 'g' (8회)

    단어 분석:
    가장 긴 단어: programming (11글자)
    가장 짧은 단어: A (1글자)

    회문 단어: level

    보고서 생성 완료!

    조건:
    StringBuilder를 사용하여 결과를 구성하세요
    Map을 사용하여 문자 빈도를 계산하세요
    문장은 '.', '!', '?'로 구분하세요
    대소문자를 구분하지 않고 분석하세요
*/

import java.util.*;
import java.util.stream.Collectors;

public class StringEx10 {
    public static int countChar(String text) {
        return text.length();
    }

    public static int countWord(String text) {
        String cleaned = text.replaceAll("[?!.]", "").toLowerCase();
        String[] array = cleaned.split(" ");

        Set<String> words = new HashSet<>(Arrays.asList(array));
        return words.size();
    }

    public static int countSentence(String text) {
        String cleaned = text.replaceAll("[?!.]", "").toLowerCase();
        return text.length() - cleaned.length();
    }

    public static Map<Character, Integer> getCharacterFrequency(String text) {

        String cleaned = text.replaceAll("[ .]", "").toLowerCase();

        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : cleaned.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        return frequency;
    }

    public static String getLongestWord(String text) {
        String cleaned = text.replaceAll("[?!.]", "").toLowerCase();
        String[] words = cleaned.split(" ");

        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    public static String getShortestWord(String text) {
        String cleaned = text.replaceAll("[?!.]", "").toLowerCase();
        String[] words = cleaned.split(" ");

        String shortest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
        }
        return shortest;
    }

    public static Set<String> getPalindromes(String text) {
        String cleaned = text.replaceAll("[?!.]", "").toLowerCase();
        String[] words = cleaned.split(" ");
        Set<String> palindromes = new HashSet<>();

        for (String word : words) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    private static boolean isPalindrome (String word) {
        StringBuilder origin = new StringBuilder(word);
        String reversed = origin.reverse().toString();

        return word.equals(reversed);
    }


    public static void main(String[] args) {
        String text = "Java is a powerful programming language. " +
                "Programming with Java is fun and level up your skills. " +
                "A good programmer never stops learning.";

        StringBuilder report = new StringBuilder();

        report.append("=== 문자열 분석 보고서 ===")
                .append("\n총 문자 수: ").append(countChar(text))
                .append("\n총 단어 수: ").append(countWord(text))
                .append("\n총 문장 수: ").append(countSentence(text))
                .append("\n");

        Map<Character, Integer> charCountMap = getCharacterFrequency(text);

        Map<Character, Integer> sortedMap = charCountMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(sortedMap.entrySet());

        String firstChar = String.format("1. %c (%d회)",
                entryList.get(0).getKey(), entryList.get(0).getValue());
        String secondChar = String.format("2. %c (%d회)",
                entryList.get(1).getKey(), entryList.get(1).getValue());
        String thirdChar = String.format("3. %c (%d회)",
                entryList.get(2).getKey(), entryList.get(2).getValue());

        report.append("\n가장 많이 사용된 문자:")
                .append("\n").append(firstChar)
                .append("\n").append(secondChar)
                .append("\n").append(thirdChar)
                .append("\n");


        String longest = getLongestWord(text);
        String longestFormat = String.format("\n가장 긴 단어: %s (%d글자)",
                longest, longest.length());
        String shortest = getShortestWord(text);
        String shortestFormat = String.format("\n가장 짧은 단어: %s (%d글자)",
                shortest, shortest.length());

        report.append("\n단어 분석:")
                .append(longestFormat)
                .append(shortestFormat)
                .append("\n");

        Set<String> palindromes = getPalindromes(text);
        String joined = String.join(" ", palindromes);

        report.append("\n회문 단어: ").append(joined);

        report.append("\n보고서 생성 완료!");

        System.out.println(report.toString());
    }
}