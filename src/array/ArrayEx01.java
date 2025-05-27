package array;

/*
    10개의 정수로 이루어진 배열을 생성하고, 1부터 100 사이의 랜덤 숫자( Math.random() 사용)로 초기화한 뒤,
    배열에서 가장 큰 숫자를 찾아 출력하는 자바 프로그램을 작성하세요. 배열과 가장 큰 숫자를 출력해야 합니다.

    예상 출력 예시:
    배열: [45, 12, 89, 34, 67, 23, 91, 56, 78, 19]
    최대값: 91

    힌트:
    (int)(Math.random() * 100 + 1)를 사용해 1~100 사이의 랜덤 정수를 생성하세요.
    배열을 순회하며 최대값을 찾으세요.
    최대값을 추적하기 위해 변수를 사용하세요.
*/


import java.util.Arrays;

public class ArrayEx01 {
    public static void main(String[] args) {

        int length = 10;
        int[] integers = new int[length];

        int max = 1;

        for (int i = 0; i < length; i++) {
            integers[i] = (int)(Math.random() * 100 +1);
            if (integers[i] > max) max = integers[i];
        }

        System.out.println("배열: " + Arrays.toString(integers));
        System.out.println("최대값: " + max);
    }
}