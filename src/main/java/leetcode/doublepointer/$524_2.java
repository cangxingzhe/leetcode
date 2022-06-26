package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.List;

public class $524_2 {
    public static void main(String[] args) {
        System.out.println(new $524_2().findLongestWord("abpcplea", List.of("a","b","c")));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String max = "";
        for (String dict : dictionary) {
            int i = 0;
            int j = 0;
            boolean flag = false;
            while(i < s.length() && j < dict.length()) {
                if(s.charAt(i) == dict.charAt(j)) {
                    i++;
                    j++;
                    if(j == dict.length() ) {
                        flag = true;
                    }
                }else {
                    i++;
                }
            }
            if(flag) {
                if(max.length() < dict.length()) {
                    max = dict;
                }else if(max.length() == dict.length()) {
                    max = max.compareTo(dict) < 0 ? max : dict;
                }
            }
        }
        return max;
    }
}
