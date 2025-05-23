package quiz;

import java.util.Optional;
import java.util.function.Consumer;

public class PrintOut<T> implements Consumer<T> {
    private T item;

    public PrintOut (T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    @Override
    public void accept(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Optional<String> names;
    }
}