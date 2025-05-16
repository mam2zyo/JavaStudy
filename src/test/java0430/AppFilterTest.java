package test.java0430;

import java.util.List;

public class AppFilterTest {
    public static void main(String[] args) {
        StoreManager<Item> storeManger = new StoreManager<>();
        StoreFilter<Item> storeFilter = new StoreFilter<>();
        System.out.println("StoreManager 초기화 완료");

        Food apple = new Food("Apple", 150);
        Food orange = new Food("Orange", 200);
        Food bread = new Food("Bread", 250);
        Drink water = new Drink("Water", 50);
        Drink juice = new Drink("Juice", 120);
        Drink coffee = new Drink("Coffee", 200);

        storeManger.addItem(apple);
        storeManger.addItem(orange);
        storeManger.addItem(bread);
        storeManger.addItem(water);
        storeManger.addItem(juice);
        storeManger.addItem(coffee);

        System.out.println("아이템 생성 완료");
        System.out.println();

        List<Item> AllItems = storeManger.getAllItems();

        List<Item> result =
                storeFilter.filterItems(AllItems, 150, 200, "a");

        if (result.isEmpty()) {
            System.out.println("조건에 맞는 상품이 없습니다.");
        } else {
            result.forEach(System.out::println);
        }
    }
}