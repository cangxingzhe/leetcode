package leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $451_2 {


    public static void main(String[] args) {
        $451_2 instance = new $451_2();
        System.out.println(instance.frequencySort("tree"));
        System.out.println(instance.frequencySort("cccaaa"));
        System.out.println(instance.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer preCount = counts.getOrDefault(s.charAt(i), 0);
            preCount++;
            counts.put(s.charAt(i), preCount);
            maxCount = Math.max(maxCount, preCount);
        }
        List<List<Character>> buckets = new ArrayList<>(maxCount+1);
        for (int i = 0; i < maxCount+1; i++) {
            buckets.add(new ArrayList<>());
        }
        counts.forEach((k, v) -> {
            List<Character> charList = buckets.get(v);
            if(charList == null) {
                charList = new ArrayList<>();
                buckets.add(v, charList);
            }
            charList.add(k);
        });
        StringBuilder result = new StringBuilder();
        for (int i = maxCount; i >= 0; i--) {
            List<Character> charList = buckets.get(i);
            if(charList != null) {
                for (Character character : charList) {
                    for (int j = 0; j < i; j++) {
                        result.append(character);
                    }
                }
            }
        }
        return result.toString();
    }
}
