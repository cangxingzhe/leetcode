package leetcode.doublepointer;

import java.util.List;

public class $524 {

    public static void main(String[] args) {
        System.out.println(new $524().findLongestWord("abpcplea",
                List.of("ale","apple","monkey","plea")));
    }


    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String s1 : dictionary) {
            int i=0;
            int j=0;
            while(i < s.length() && j < s1.length()) {
                if(s.charAt(i) == s1.charAt(j)) {
                    i++;
                    j++;
                }else {
                    i++;
                }
            }
            if(j == s1.length()) {
                if(result.equals("")) {
                    result = s1;
                }else {
                    if(s1.length() > result.length() || (s1.length() == result.length() && s1.compareTo(result) < 0)) {
                        result = s1;
                    }
                }
            }
        }
        return result;
    }
}
