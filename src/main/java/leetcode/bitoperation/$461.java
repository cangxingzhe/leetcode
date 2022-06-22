package leetcode.bitoperation;

public class $461 {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }

    static class Solution {
        public int hammingDistance(int x, int y) {
            int ans = 0, diff = x ^ y;
            while(diff > 0) {
                ans += diff & 1;
                diff = diff >> 1;
            }
            return  ans;
        }
    }
}
