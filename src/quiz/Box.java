package quiz;

import java.util.List;

public class Box<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        List<String> words = List.of("hi", "hello", "java", "code");


        List<String> newList = words.stream()
                .filter(s -> s.length() >= 4)
                .toList();
    }
}