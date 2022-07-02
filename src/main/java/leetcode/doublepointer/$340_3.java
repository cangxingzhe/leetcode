package leetcode.doublepointer;

import java.util.LinkedHashMap;
import java.util.Map;

public class $340_3 {

    public static void main(String[] args) {
        System.out.println(new $340_3().lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(new $340_3().lengthOfLongestSubstringKDistinct("aa", 1));
    }



    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = 0;
        int maxSize = 0;
        Map<Character, Integer> flags = new LinkedHashMap<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            flags.remove(c);
            flags.put(c, right++);
            if(flags.size() == k + 1) {
                Map.Entry<Character, Integer> entry = flags.entrySet().iterator().next();
                flags.remove(entry.getKey());
                left = entry.getValue() + 1;
            }
            maxSize = Math.max(maxSize, right - left);
        }
        return maxSize;
    }
}
