package string.ex;

/*
    주어진 문자열에서 모든 공백을 제거하고, 첫 글자만 대문자로 바꾸는 프로그램을 작성하세요.

    입력 예: "hello java programming"
    출력 예: "Hellojavaprogramming"
*/

public class StringEx1 {
    public static void main(String[] args) {

        String hello = "hello java programming";
        String noSpaces = hello.replace(" ", ""); // 공백 제거,

        String result = Character.toUpperCase(noSpaces.charAt(0)) +
                noSpaces.substring(1);  // 첫글자 대문자, concat

        System.out.println(result);

//        String[] helloArr = hello.split("");
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(helloArr[0].toUpperCase());
//        for (int i = 1; i < helloArr.length; i++) {
//            if(!helloArr[i].equals(" ")) {
//                sb.append(helloArr[i]);
//            }
//        }
//        System.out.println(sb);
    }
}
