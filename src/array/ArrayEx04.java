package array;

/*
    8개의 정수로 이루어진 배열을 생성하고, 1~50 사이의 랜덤 정수로 초기화하세요.
    배열을 정렬한 뒤, Arrays.binarySearch()를 사용해 사용자가 입력한 숫자(예: 42)를 찾아
    해당 숫자가 배열에 있는지, 있다면 어느 인덱스에 있는지 출력하세요.
    정렬 전과 정렬 후 배열, 그리고 검색 결과를 출력하세요.

    예상 출력:
    정렬 전 배열: [45, 12, 33, 7, 42, 19, 28, 50]
    정렬 후 배열: [7, 12, 19, 28, 33, 42, 45, 50]
    검색 숫자 42는 인덱스 5에 있습니다.

    힌트:
    * Math.random()으로 1~50 사이의 값을 생성.
    * Arrays.sort()로 배열 정렬.
    * Arrays.binarySearch()로 숫자 검색.
    * 검색 결과가 음수면 숫자가 없음을 의미.
    * 입력은 하드코딩(예: int searchKey = 42)해도 됩니다.
*/

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx04 {
    public static void main(String[] args) {

        int length = 8;
        int[] originInts = new int[length];

        for (int i = 0; i < length; i++) {
            originInts[i] = (int) (Math.random() * 50 + 1);
        }

        int[] copiedInts = Arrays.copyOf(originInts, originInts.length);
        Arrays.sort(copiedInts);

        System.out.print("검색 숫자 입력: ");
        Scanner scanner = new Scanner(System.in);
        int searchKey = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        System.out.println("정렬 전 배열: " + Arrays.toString(originInts));
        System.out.println("정렬 후 배열: " + Arrays.toString(copiedInts));

        int index = Arrays.binarySearch(copiedInts,searchKey);

        if (index < 0) {
            System.out.printf("검색 숫자 %d은(는) 배열에 없습니다.\n", searchKey);
        } else {
            System.out.printf("검색 숫자 %d은(는) 인덱스 %d에 있습니다.\n",
                    searchKey, index);
        }
    }
}