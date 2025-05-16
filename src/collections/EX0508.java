package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// [도전 문제] 중복 이름 찾기
// 문제 설명
// 사용자 이름 목록이 담긴 List<String>이 주어졌을 때,
// 중복된 이름만 찾아서 한 번씩만 담은 리스트를 반환하는 메서드를 작성하세요.
//
//
// 입력: ["Alice", "Bob", "alice", "Alice", "BOB", "Bob"]
// 출력: ["Alice", "Bob"]
// Alice는 2번, Bob도 2번 등장하므로 출력 대상
//
// 대소문자는 구분함
//
// alice, BOB는 각각 1번만 등장하므로 출력 대상 아님


public class EX0508 {

    public List<String> findDuplicates(List<String> names) {
        Map<String, Integer> nameMap = new HashMap<>();

        for (String name : names) {
            nameMap.put(name, nameMap.getOrDefault(name,0) + 1);
        }

        return nameMap.keySet().stream()
                .filter(name -> nameMap.get(name) > 1)
                .toList();
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("alice");
        names.add("Alice");
        names.add("BOB");
        names.add("Bob");

        EX0508 ex = new EX0508();

        List<String> result = ex.findDuplicates(names);

        for (String name : result) {
            System.out.println(name);
        }
    }
}