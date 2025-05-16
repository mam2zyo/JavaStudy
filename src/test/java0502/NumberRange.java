package test.java0502;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumberRange implements Iterable<Integer>{
    private final int start;
    private final int end;

    public NumberRange(int start, int end) {
        if (start > end) { // 입력 조건 검증
            throw new IllegalArgumentException(
                    "Start must be less then or equal to end");
        }
        this.start = start;
        this.end = end;
     }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() { // Iterator 객체를 반환하는 익명 클래스
            private int current = start; // Iterator<E> 구현하려면 2개 추상메서드 구현 펼요

            @Override
            public boolean hasNext() { // boolean hsaNext() 추상메서드 구현
                return current <= end;
            }

            @Override
            public Integer next() { // E next() 메서드 여기서는 type argument가 Integer
                if(!hasNext()) {
                    throw new NoSuchElementException();
                }
                return current++;
            }
        };
    }

    public static void main(String[] args) {
        NumberRange range = new NumberRange(1, 7);

        for (Integer i : range) {
            System.out.println(i);
        }
    }
}