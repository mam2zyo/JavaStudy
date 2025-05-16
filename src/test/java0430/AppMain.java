package test.java0430;

import java.util.List;
import java.util.Map;

public class AppMain {

    public static void main(String[] args) {
        StoreManager<Item> sm = new StoreManager<>();

        Item apple = new Food("Apple", 150);
        Item water = new Drink("Water", 50);
        Item bread = new Food("Bread", 200);
        Item toy = new ItemSub("Toy", 300);

        sm.addItem(apple);
        sm.addItem(water);
        sm.addItem(bread);
        sm.addItem(toy);

        List<Item> AllItems = sm.getAllItems();

        Map<String, List<Item>> maplist = sm.getItemMap(AllItems);

        sm.showItemMap(maplist);
    }
}