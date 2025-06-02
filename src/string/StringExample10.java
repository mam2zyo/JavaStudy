package string;

import java.util.*;

public class StringExample10 {
    public static void main(String[] args) {
        // 1. 문자열 회문(Palindrome) 검사
        System.out.println("=== 회문 검사 ===");
        String[] testWords = {"level", "hello", "racecar", "A man a plan a canal Panama"};

        for (String word : testWords) {
            System.out.println("'" + word + "' 회문 여부: " + isPalindrome(word));
        }

        // 2. 애너그램(Anagram) 검사
        System.out.println("\n=== 애너그램 검사 ===");
        String[][] anagramPairs = {
                {"listen", "silent"},
                {"elbow", "below"},
                {"hello", "world"},
                {"dormitory", "dirty room"}
        };

        for (String[] pair : anagramPairs) {
            System.out.println("'" + pair[0] + "'와 '" + pair[1] + "' 애너그램 여부: " +
                    isAnagram(pair[0], pair[1]));
        }

        // 3. 문자열에서 중복 문자 제거
        System.out.println("\n=== 중복 문자 제거 ===");
        String duplicateText = "programming";
        System.out.println("원본: " + duplicateText);
        System.out.println("중복 제거: " + removeDuplicates(duplicateText));

        // 4. 문자열 압축 (Run Length Encoding)
        System.out.println("\n=== 문자열 압축 ===");
        String[] compressTargets = {"aabcccccaaa", "abcdef", "aabbcc"};
        for (String target : compressTargets) {
            System.out.println("원본: " + target + " → 압축: " + compress(target));
        }

        // 5. 최장 공통 부분 문자열 (Longest Common Substring)
        System.out.println("\n=== 최장 공통 부분 문자열 ===");
        String str1 = "GeeksforGeeks";
        String str2 = "GeeksQuiz";
        System.out.println("문자열1: " + str1);
        System.out.println("문자열2: " + str2);
        System.out.println("최장 공통 부분 문자열: " + longestCommonSubstring(str1, str2));

        // 6. 문자열 패턴 매칭 (단순 구현)
        System.out.println("\n=== 패턴 매칭 ===");
        String text = "ABABDABACDABABCABCABCABCABC";
        String pattern = "ABABCABCABCABC";
        System.out.println("텍스트: " + text);
        System.out.println("패턴: " + pattern);
        System.out.println("패턴 위치: " + findPattern(text, pattern));

        // 7. 부분 문자열의 모든 순열 생성
        System.out.println("\n=== 문자열 순열 ===");
        String permutationStr = "ABC";
        System.out.println("'" + permutationStr + "'의 모든 순열:");
        List<String> permutations = generatePermutations(permutationStr);
        for (String perm : permutations) {
            System.out.print(perm + " ");
        }
        System.out.println();

        // 8. 문자 빈도수 계산
        System.out.println("\n=== 문자 빈도수 ===");
        String frequencyText = "hello world";
        Map<Character, Integer> frequency = getCharacterFrequency(frequencyText);
        System.out.println("'" + frequencyText + "'의 문자 빈도수:");
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }

    // 회문 검사
    public static boolean isPalindrome(String str) {
        // 공백과 특수문자 제거, 소문자 변환
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 애너그램 검사
    public static boolean isAnagram(String str1, String str2) {
        // 공백 제거, 소문자 변환
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    // 중복 문자 제거
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }

    // 문자열 압축 (Run Length Encoding)
    public static String compress(String str) {
        if (str.isEmpty()) return str;

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char current = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == current) {
                count++;
            } else {
                compressed.append(current).append(count);
                current = str.charAt(i);
                count = 1;
            }
        }
        compressed.append(current).append(count);

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // 최장 공통 부분 문자열
    public static String longestCommonSubstring(String str1, String str2) {
        int maxLength = 0;
        int endPos = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endPos = i;
                    }
                }
            }
        }

        return str1.substring(endPos - maxLength, endPos);
    }

    // 패턴 매칭 (단순 구현)
    public static List<Integer> findPattern(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                positions.add(i);
            }
        }

        return positions;
    }

    // 문자열 순열 생성
    public static List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        generatePermutationsHelper("", str, result);
        return result;
    }

    private static void generatePermutationsHelper(String prefix, String remaining, List<String> result) {
        if (remaining.length() == 0) {
            result.add(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutationsHelper(newPrefix, newRemaining, result);
        }
    }

    // 문자 빈도수 계산
    public static Map<Character, Integer> getCharacterFrequency(String str) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        return frequency;
    }
}