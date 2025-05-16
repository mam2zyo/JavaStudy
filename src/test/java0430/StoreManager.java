package test.java0430;

import java.util.*;

public class StoreManager<T extends Item> {
    private final List<T> items;
    private final Map<String, Set<T>> categoryMap;

    public StoreManager() {
        this.items = new ArrayList<>();
        this.categoryMap = new HashMap<>();

        categoryMap.put("Food", new HashSet<>());  // 생성자에 Map 초기화
        categoryMap.put("Drink", new HashSet<>());
        categoryMap.put("Unknown", new HashSet<>());
    }

    public void addItem(T item) {
        if (item == null) {
            throw new IllegalArgumentException("item은 null 일 수 없습니다.");
        }

        items.add(item);
        if (item instanceof Food) {
            categoryMap.get("Food").add(item); //categoryMap.get() 결과는 HashSet()

        } else if (item instanceof Drink) {
            categoryMap.get("Drink").add(item);

        } else {
            categoryMap.get("Unknown").add(item);
        }
    }

    public Optional<T> findItem(String name) {
        return  items.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();
    }

    public void showItem(Optional<T> found) {

        if (found.isPresent()) {
            System.out.println(found.get());
        } else {
            System.out.println("조건에 맞는 상품이 없습니다.");
        }
    }

    public void showItemsByCategory(String category) {
        Set<T> categoryItems =
                categoryMap.getOrDefault(category, Collections.emptySet());

        if (categoryItems == null || categoryItems.isEmpty()) {
            System.out.println("해당 카데고리에 상품이 없습니다.");
        } else {
            System.out.println(category + "카테고리 상품 목록:");
            categoryItems.forEach(System.out::println);
        }
    }

    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }

    public Map<String, List<Item>> getItemMap (List<Item> items) {
        Map<String, List<Item>> itemMap = new HashMap<>();

        itemMap.put("Food", new ArrayList<>());
        itemMap.put("Drink", new ArrayList<>());
        itemMap.put("Unknown", new ArrayList<>());

        for (Item item : items) {
            if (item instanceof Food) {
                itemMap.get("Food").add(item);
            } else if(item instanceof Drink) {
                itemMap.get("Drink").add(item);
            } else {
                itemMap.get("Unknown").add(item);
            }
        }return itemMap;
    }

    public void showItemMap(Map<String, List<Item>> itemMap) {
        Set<String> keySet = itemMap.keySet();

        System.out.println("{");
        for (String key : keySet) {
            System.out.print("\"" + key + "\"" + " -> ");
            System.out.print("[");
            for (Item item : itemMap.get(key)) {
                System.out.print(item.getName() + ", ");
            }
            System.out.println("],");
        }
        System.out.println("}");
    }
}