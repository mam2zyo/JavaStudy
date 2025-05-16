package test.java0430;

import java.util.List;
import java.util.Set;

public class AppSortTest {
    public static void main(String[] args) {
        // 1. Instantiate StoreManager and StoreSorter
        System.out.println("Initializing Store Manager and Sorter...");
        StoreManager<Item> storeManager = new StoreManager<>();
        StoreSorter<Item> storeSorter = new StoreSorter<>();
        System.out.println("Initialization complete.\n");

        // 2. Add Items to StoreManager
        Food apple = new Food("Apple", 150);
        Food orange = new Food("Orange", 200);
        Food bread = new Food("Bread", 250);
        Drink water = new Drink("Water", 50);
        Drink juice = new Drink("Juice", 120);
        Drink coffee = new Drink("Coffee", 200); // Same price as orange
        Food apple2 = new Food("Apple", 150); // Duplicate item (same name, same price)

        try {
            storeManager.addItem(apple);
            storeManager.addItem(orange);
            storeManager.addItem(bread);
            storeManager.addItem(water);
            storeManager.addItem(juice);
            storeManager.addItem(coffee);
            storeManager.addItem(apple2); // Add the duplicate
            // Test adding null
            // storeManager.addItem(null); // Uncomment to test exception
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding item: " + e.getMessage());
        }
    }


}
