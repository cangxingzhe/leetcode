package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class $451 {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }

        List<Character> items = new ArrayList<>();
        for(int i = 0; i < 128; i++){
            if(count[i] != 0){
                items.add((char)i);
            }
        }
        items.sort((o1, o2) -> count[o2] - count[o1]);
        StringBuilder res = new StringBuilder();
        for(char c : items){
            for(int i = 0; i < count[c]; i++){
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        $451 instance = new $451();
        System.out.println(instance.frequencySort("tree"));
        System.out.println(instance.frequencySort("cccaaa"));
        System.out.println(instance.frequencySort("Aabb"));
    }
}
