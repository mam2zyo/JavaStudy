package test.java0430;

public class Food extends Item{
    public Food (String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Food: " + this.getName() + ", " + this.getPrice();
    }
}
