package array;

/*
    문제: 배열을 기반으로 한 MyArrayList 클래스에 remove(int index) 메서드를 추가하세요.
    이 메서드는 지정된 인덱스의 요소를 삭제하고, 이후 요소들을 왼쪽으로 이동시킨 후
    삭제된 요소를 반환합니다. 기본 배열 크기는 5로 설정하고, 1~10 사이의 랜덤 정수 5개를
    추가한 뒤, 인덱스 2의 요소를 삭제하고 리스트 상태를 출력하세요.

    예상 출력 예시:
    원본 리스트: [7, 3, 9, 2, 5]
    인덱스 2의 삭제된 요소: 9
    삭제 후 리스트: [7, 3, 2, 5]

    힌트:
    * remove(int index)는 index 위치의 요소를 삭제하고,
      index+1부터 끝까지의 요소를 한 칸씩 왼쪽으로 이동.
    * size를 감소시키고, 삭제된 요소를 반환.
    * 배열이 꽉 찼을 때 add 메서드에서 배열 확장을 처리.
    * 리스트 상태는 toString() 메서드나 루프를 사용해 출력.
 */

import java.util.Arrays;

public class ArrayEx06 {

    static public class MyArrayList {
        private int[] data;
        private int size;
        private static final int DEFAULT_CAPACITY = 10;

        public MyArrayList() {
            data = new int[DEFAULT_CAPACITY];
            size = 0;
        }

        // 배열 끝에 요소 추가
        public void add(int element) {
            if (size == data.length) {
                // 배열 크기 두 배로 확장
                int[] newData = new int[data.length * 2];
                for (int i = 0; i < size; i++) {
                    newData[i] = data[i];
                }
                data = newData;
            }
            data[size++] = element;
        }

        // 인덱스의 요소 반환
        public int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("유효하지 않은 인덱스: " + index);
            }
            return data[index];
        }

        public int size() {
            return size;
        }

        public int remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("유효하지 않은 인덱스: " + index);
            }

            int removed = data[index];
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;

            return removed;

//            int[] newData = new int[size - 1];
//
//            for (int i = 0; i < index; i++) {
//                newData[i] = data[i];
//            }
//            for (int i = index; i < size -1; i++) {
//                newData[i] = data[i+1];
//            }//
//            data = newData;
//            size--;
        }

        @Override
        public String toString() {
            int[] list = Arrays.copyOf(data, size);
            return Arrays.toString(list);
        }
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        for (int i = 0; i < 5; i++) {
            list.add((int)(Math.random() * 10 + 1));
        }

        System.out.println("원본 리스트: " + list);

        int removed = list.remove(2);
        System.out.println("인덱스 2의 삭제된 요소: " + removed);
        System.out.println("삭제 후 리스트: " + list);
    }
}