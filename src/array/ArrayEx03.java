package array;

/*
    문제: 3x3 2D 배열을 생성하고, 1~9 사이의 랜덤 정수로 초기화하세요. 배열을 출력한 뒤,
    주 대각선(즉, matrix[0][0], matrix[1][1], matrix[2][2]) 요소의 합을 계산해 출력하세요.

    예상 출력:

    3x3 배열:
    4 7 2
    1 8 5
    9 3 6
    주 대각선 합: 18 (4 + 8 + 6)

    힌트:
    * 3x3 배열을 선언하고 (int)(Math.random() * 9 + 1)로 1~9 사이의 랜덤 값을 채우세요.
    * 주 대각선은 matrix[i][i]로 접근할 수 있습니다.
    * Arrays.toString() 또는 중첩 루프를 사용해 배열을 출력하세요.
*/


public class ArrayEx03 {

    public static void main(String[] args) {

        //  init Matrix
        int rows = 3;
        int cols = 3;

        int[][] matrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (int) (Math.random() * 9 + 1);
            }
        }

        // print Matrix
        System.out.println("3x3 배열:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // sum of diagonal elem
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += matrix[i][i];
        }

        System.out.printf("주 대각선 합: %d (%d + %d + %d)"
        , sum, matrix[0][0], matrix[1][1], matrix[2][2]);

    }
}