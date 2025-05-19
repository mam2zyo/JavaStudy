package string.ex;

/*
 주어진 문자열에서 모든 소문자 'a'를 대문자 'A'로 바꾸고,
 문자 'e'가 몇 번 등장하는지 세는 프로그램을 작성하세요.
 입력 예: "Java examples are effective for learning"
 출력 예: "JAvA exAmples Are effective for leArning"
         "문자 'e'의 등장 횟수: 5"
*/

public class StringEx2 {
    public static void main(String[] args) {

        String str = "Java examples are effective for learning";

        String replaced = str.replace("a", "A");
        System.out.println(replaced);

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                count++;
            }
        }
        System.out.println("문자 'e'의 등장 횟수: " + count);

//        String regex = str.replaceAll("e", "");
//        int countOfe = str.length() - regex.length();
//        System.out.println("문자 'e'의 등장 횟수:" + countOfe);

    }
}