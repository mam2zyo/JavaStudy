package array;

/*
    public class SlidingWindowExample {
        public static void main(String[] args) {
            int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
            int k = 4; // 윈도우 크기

            int maxSum = findMaxSumWindow(arr, k);
            System.out.println("크기 " + k + " 윈도우의 최대 합: " + maxSum);
        }

        public static int findMaxSumWindow(int[] arr, int k) {
            if (arr == null || k <= 0 || k > arr.length) {
                throw new IllegalArgumentException("유효하지 않은 입력");
            }

            // 첫 번째 윈도우의 합 계산
            int windowSum = 0;
            for (int i = 0; i < k; i++) {
                windowSum += arr[i];
            }

            // 슬라이딩 윈도우로 최대 합 계산
            int maxSum = windowSum;
            for (int i = k; i < arr.length; i++) {
                windowSum = windowSum + arr[i] - arr[i - k]; // 새 요소 추가, 첫 요소 제거
                maxSum = Math.max(maxSum, windowSum);
            }

            return maxSum;
        }
    }
*/

/*
    10개의 정수로 이루어진 배열을 생성하고, 1~50 사이의 랜덤 정수로 초기화하세요.
    윈도우 크기 k=3인 슬라이딩 윈도우를 사용해 모든 윈도우의 합을 계산하고,
    각 윈도우의 합을 배열로 저장한 뒤 출력하세요. Arrays.toString()을 사용해 결과를 출력하세요.

    예상 출력 예시:
    원본 배열: [12, 45, 23, 7, 19, 34, 8, 41, 15, 30]
    윈도우 합 배열: [80, 75, 49, 60, 61, 83, 64, 86]

    힌트:
    * 윈도우 크기 k=3이므로 합의 개수는 arr.length - k + 1.
    * 첫 윈도우 합을 계산한 뒤, 슬라이딩 윈도우로 다음 합을 계산(windowSum += arr[i] - arr[i-k]).
    * 결과를 저장할 배열을 만들고 각 윈도우 합을 저장.
    * 예외 처리(null, k <= 0, k > arr.length)를 포함.

    풀이 접근법:
    10개 정수 배열을 1~50 랜덤 값으로 초기화.
    원본 배열 출력.
    슬라이딩 윈도우로 각 윈도우의 합을 계산해 배열에 저장.
    윈도우 합 배열 출력.
*/

import java.util.Arrays;

public class ArrayEX07 {

    public static int[] getWindowSumArray(int[] arr, int k) {

        if (arr == null || k < 1 || k > arr.length) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        int size = arr.length - k + 1;
        int[] sumArray = new int[size];

        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        sumArray[0] = windowSum;

        for (int i = k; i < arr.length; i++) {
            windowSum = windowSum + arr[i] - arr[i - k];
            sumArray[i - k + 1] = windowSum;
        }

        return sumArray;
    }

    public static void main(String[] args) {
        int[] integers = new int[10];
        int k = 3;

        for (int i = 0; i < integers.length; i++) {
            integers[i] = (int) (Math.random() * 50 + 1);
        }

        int[] sumArray = getWindowSumArray(integers, k);

        System.out.println("원본 배열: " + Arrays.toString(integers));
        System.out.println("윈도우 합 배열: " + Arrays.toString(sumArray));
    }
}