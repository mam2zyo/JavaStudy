package string.ex;

// 주어진 문자열이 유효한 비밀번호인지 확인하는 프로그램을 작성하세요.
// 비밀번호 규칙은 다음과 같습니다:

// 1. 최소 8자 이상
// 2. 최소 하나의 대문자 포함
// 3. 최소 하나의 소문자 포함
// 4. 최소 하나의 숫자 포함
// 5. 특수문자(!@#$%^&*) 중 하나 이상 포함

// 입력 예:
// String[] passwords = {
//        "Abc123!",       // 길이 부족
//        "abcdefgh",      // 대문자, 숫자, 특수문자 없음
//        "ABCDEFGH",      // 소문자, 숫자, 특수문자 없음
//        "Abcdefgh1",     // 특수문자 없음
//        "Abcdefgh!",     // 숫자 없음
//        "Password123!"   // 유효한 비밀번호
// };

// 출력 예:
// Abc123! - 유효하지 않음 (최소 8자 이상이어야 합니다)
// abcdefgh - 유효하지 않음 (대문자, 숫자, 특수문자가 없습니다)
// ABCDEFGH - 유효하지 않음 (소문자, 숫자, 특수문자가 없습니다)
// Abcdefgh1 - 유효하지 않음 (특수문자가 없습니다)
// Abcdefgh! - 유효하지 않음 (숫자가 없습니다)
// Password123! - 유효한 비밀번호

import java.util.ArrayList;
import java.util.List;

public class StringEx4 {

    public static void isValidPassword(String password) {
        if (password.length() < 8) {
            System.out.println(password + " - 유효하지 않음 (최소 8자 이상이어야 합니다)");
            return;
        }

        boolean hasCapitalLetter = false;
        boolean hasLowerLetter = false;
        boolean hasDigit = false;
        boolean hasSpecialCharacter = false;
        String special = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasCapitalLetter = true;
            }
            if (c >= 'a' && c <= 'z') {
                hasLowerLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if (special.indexOf(c) >= 0) { // indexOf()는 없으면 -1 반환
                hasSpecialCharacter = true;
            }
        }
        if (hasCapitalLetter && hasLowerLetter && hasDigit && hasSpecialCharacter) {
            System.out.println(password + " - 유효한 비밀번호");
        } else {
            List<String> reasons = new ArrayList<>();

            if (!hasCapitalLetter) reasons.add("대문자");
            if (!hasLowerLetter) reasons.add("소문자");
            if (!hasDigit) reasons.add("숫자");
            if (!hasSpecialCharacter) reasons.add("특수문자");

            System.out.println(password + " - 유효하지 않음 (" +
                    String.join(", ", reasons) +
                    "가 없습니다)");
        }
    }

    public static void main(String[] args) {
        String[] passwords = {
                "Abc123!",       // 길이 부족
                "abcdefgh",      // 대문자, 숫자, 특수문자 없음
                "ABCDEFGH",      // 소문자, 숫자, 특수문자 없음
                "Abcdefgh1",     // 특수문자 없음
                "Abcdefgh!",     // 숫자 없음
                "Password123!"   // 유효한 비밀번호
        };

        for (String password : passwords) {
            isValidPassword(password);
        }
    }
}