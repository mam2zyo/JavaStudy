package test.java0501;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest<T, U> implements Boxable<U>{

    T item;

    public void wrapItem (List<? super T> list) {
        list.add(item);

        if (!list.isEmpty()) {

        }



    }

    public T getFromList(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public <S extends U> U loveYou(List<S> list) {

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void toBox(U u) {
        List<U> list = new ArrayList<>();
        list.add(u);
        System.out.println("item to Box!");
    }

    public static void main(String[] args) {

        List<?> li0 = new ArrayList<>();
        List<Integer> li = new ArrayList<>();

        System.out.println(li instanceof List<?>);
        System.out.println(li instanceof List<? extends Number>);
    }
}