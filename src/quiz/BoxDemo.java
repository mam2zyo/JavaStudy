package quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoxDemo {

    static <T> T pick(T a1, T a2) { return a2; }

    public static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        ArrayList<Box<Integer>> listOfIntegerBoxes =
                new ArrayList<>();

        ArrayList<String> arrayList = new ArrayList<>();

        Serializable s = pick("d", new ArrayList<String>());

//        BoxDemo.<Integer>addBox();
    }
}