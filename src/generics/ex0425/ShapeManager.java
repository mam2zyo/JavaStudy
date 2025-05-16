package generics.ex0425;

import java.util.ArrayList;
import java.util.List;

public class ShapeManager<T extends Shape> {
    List<T> shapes = new ArrayList<>();

    public void addShape(T shape) {
        shapes.add(shape);
    }

    public void printShapes() {
        shapes.forEach(s -> System.out.println(s.getName()));
    }
}