package test.java0430;

public class Drink extends Item{
    public Drink (String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink: " + this.getName() + ", " + this.getPrice();
    }
}
