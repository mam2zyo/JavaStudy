package test.java0430;

import java.util.List;

public class StoreFilter<T extends Item> {
    public List<T> filterItems(List<T> items, int minPrice, int maxPrice, String keyword) {

        if (keyword == null) keyword = "";  // 검색어를 입력하지 않아도 NPE 피해갈 수 있게
        String loweredKey = keyword.toLowerCase();

        return items.stream()
                .filter(item -> item.getPrice() >= minPrice)
                .filter(item -> item.getPrice() <= maxPrice)
                .filter(item -> item.getName().toLowerCase().contains(loweredKey))
                .toList(); // .toList() Java 16 에 도입
                //.collect(Collectors.toList()) Java 8 이상부터 가능(호환성 보장)
    }
}