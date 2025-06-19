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

public class ArrayEX07 {
}
