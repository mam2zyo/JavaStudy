package quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {

    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void main(String[] args) {
        Serializable s = pick("d", new ArrayList<String>());

        List<String> list = new ArrayList<>();
        list.add("korea");
        list.add("usa");
        list.add("england");
        list.add("japan");

        String[]strs = new String[list.size()];

        list.toArray(strs);
        // <T> T[] toArray(T[] a);

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}