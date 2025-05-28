package array;

/*
    10개의 정수로 이루어진 배열을 생성하고, 1부터 50 사이의 랜덤 숫자로 초기화하세요.
    그 후, 배열에서 짝수만 골라 새로운 배열에 저장하고, 원래 배열과 짝수 배열을 출력하세요.
    만약 짝수가 없다면 "짝수가 없습니다"를 출력하세요.

    예상 출력 예시:
    원래 배열: [23, 12, 45, 8, 16, 33, 24, 19, 42, 7]
    짝수 배열: [12, 8, 16, 24, 42]

    힌트:
    * (int)(Math.random() * 50 + 1)를 사용해 1~50 사이의 랜덤 정수를 생성하세요.
    * 먼저 배열을 순회하며 짝수의 개수를 세고, 그 개수만큼의 새로운 배열을 생성하세요.
    * 다시 배열을 순회하며 짝수를 새 배열에 저장하세요.
    * Arrays.toString()를 사용해 배열을 출력하세요.
*/


import java.util.Arrays;

public class ArrayEx02 {
    public static void main(String[] args) {

        int length = 10;
        int[] integers = new int[length];

        for (int i = 0; i < length; i++) {
            integers[i] = (int)(Math.random() * 50 +1);
        }

        int evenCount = 0;
        for (int integer : integers) {
            if (integer % 2 == 0) evenCount++;
        }

        if (evenCount == 0) {
            System.out.println("짝수가 없습니다.");
            return;
        }

        int[] evenNumbers = new int[evenCount];

        int i = 0;

        for (int integer : integers) {
            if (integer % 2 == 0) evenNumbers[i++] = integer; // index 활용 기억
        }
        System.out.println("원래 배열: " + Arrays.toString(integers));
        System.out.println("짝수 배열: " + Arrays.toString(evenNumbers));
    }
}