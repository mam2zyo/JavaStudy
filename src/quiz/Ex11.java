package quiz;

import java.util.List;

public class Ex11 {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    public static void main(String[] args) {

        List<Integer> intList = List.of(2, 4, 8);

        sumOfList(intList);

        System.out.println(sumOfList(intList));
    }
}