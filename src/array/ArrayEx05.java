package array;

/*
    public class ArrayRotationExample {
        public static void main(String[] args) {
            // 배열 선언 및 초기화
            int[] arr = {1, 2, 3, 4, 5};
            int k = 2; // 왼쪽으로 2번 회전

            System.out.println("원본 배열: " + Arrays.toString(arr));

            // 배열 회전
            rotateLeft(arr, k);

            System.out.println("회전 후 배열: " + Arrays.toString(arr));
        }

        // 배열을 왼쪽으로 k번 회전
        public static void rotateLeft(int[] arr, int k) {
            if (arr == null || arr.length <= 1 || k <= 0) return;

            // k를 배열 길이로 나눈 나머지로 정규화
            k = k % arr.length;
            int[] temp = new int[k];

            // 첫 k개의 요소를 임시 배열에 저장
            for (int i = 0; i < k; i++) {
                temp[i] = arr[i];
            }

            // 나머지 요소를 앞으로 이동
            for (int i = 0; i < arr.length - k; i++) {
                arr[i] = arr[i + k];
            }

            // 임시 배열의 요소를 배열 끝에 배치
            for (int i = 0; i < k; i++) {
                arr[arr.length - k + i] = temp[i];
            }
        }
    }
*/


/*
    6개의 정수로 이루어진 배열을 생성하고, 1~30 사이의 랜덤 정수로 초기화하세요.
    사용자가 입력한 숫자 k만큼 배열을 오른쪽으로 회전한 뒤, 원본 배열과 회전된 배열을 출력하세요.
    Arrays.toString()을 사용해 배열을 출력하세요.

    예상 출력 예시:
    원본 배열: [10, 15, 22, 7, 29, 12]
    k 입력: 2
    회전 후 배열: [29, 12, 10, 15, 22, 7]

    힌트:
    오른쪽 회전은 왼쪽 회전과 반대 방향입니다. 예: {1, 2, 3, 4, 5}를 오른쪽으로 2번 회전하면 {4, 5, 1, 2, 3}.
    k를 정규화(k % arr.length)하여 큰 k 값을 처리.
    임시 배열을 사용하거나, 요소를 뒤에서 앞으로 이동시키는 방식으로 구현.
    Scanner로 k를 입력받거나, 하드코딩(예: int k = 2)해도 됩니다.
*/


import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx05 {

    public static int[] getRotatedRight(int[] arr, int k) {

        if (arr == null) {
            throw new IllegalArgumentException("Invalid argument : array is null");
        }
        if (arr.length <= 1) {
            throw new IllegalArgumentException("Array length should be > 1");
        }
        if (k <= 0) {
            throw new IllegalArgumentException("k must be positive integer");
        }

        k = k % arr.length;
        int[] rotatedArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            rotatedArr[i] = arr[(i + arr.length - k) % arr.length];
        }

        return rotatedArr;
    }


    public static void main(String[] args) {

        int length = 6;
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 30 + 1);
        }

        System.out.println("원본 배열: " + Arrays.toString(arr));
        System.out.print("k 입력: ");

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        scanner.close();

        int[] result = getRotatedRight(arr, k);
        System.out.println("회전 후 배열: " + Arrays.toString(result));
    }
}