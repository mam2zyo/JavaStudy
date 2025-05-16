package quiz;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MyClass<X> {

    private X x;

    <T> MyClass (T t) {
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        MyClass<Integer> integerClazz =
                new <String>MyClass<Integer>("Object Created!");

        integerClazz.setX(31);
        System.out.println(integerClazz.getX());
    }
}
