package leetcode.doublepointer;

public class $340_2 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int cnt = 0;
        int[] chars = new int[127];
        int minLeft = 0;
        int maxSize = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            int pos = s.charAt(r) - 'a';
            if(chars[pos] == 0) {
                if(cnt < k) {
                    cnt++;
                }else {

                }
            }
        }
    }

}
