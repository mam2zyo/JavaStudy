package quiz;

public class EX1 {
    public static void main(String[] args) {
        String str1 = "Python";
        String str2 = new String("Python");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
