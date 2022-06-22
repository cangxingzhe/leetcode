package leetcode.doublepointer;

public class $340 {
    public static void main(String[] args) {
        System.out.println(new $340().lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int[] key = new int[128];
        int left = 0, right = 0, max = 0;
        for (;right<len;right++) {
            if (key[s.charAt(right)] == 0) max++;
            key[s.charAt(right)]++;
            if (max > k) {
                key[s.charAt(left)]--;
                if (key[s.charAt(left)] == 0) max--;
                left++;
            }
        }
        System.out.println(s.substring(left, right));
        return right - left;
    }
}
