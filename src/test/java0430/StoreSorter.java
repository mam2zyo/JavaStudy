package test.java0430;

import java.util.*;

public class StoreSorter<T extends Item> {

    public Set<T> sortItem(List<T> items, boolean byPriceAscending) {
        // 중복 제거용으로  TreeSet 사용시 비교 결과가 같으면, 동일한 객체로 보고
        // 뒤에 삽입되는 객체가 무시됨. 가격으로 정렬시 가격이 동일한 두 객체가 있으면
        // 나중에 삽입되는 객체는 무시됨. 비교값이 같지 않도록 조건을 명확하게 할 필요가 있음
        // 이것은 equals 나 hashCode 와는 무관함 (수정해도 무시됨)

        Comparator<T> byPrice = Comparator.comparing(Item::getPrice);
        Comparator<T> byName = Comparator.comparing(Item::getName);

        Comparator<T> comparator = byPriceAscending ?
                byPrice.thenComparing(byName) :
                byPrice.reversed().thenComparing(byName);

        Set<T> sortedSet = new TreeSet<>(comparator);
        items.forEach((sortedSet::add));
        return sortedSet;
    }
}