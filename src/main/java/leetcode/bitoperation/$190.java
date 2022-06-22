package leetcode.bitoperation;

public class $190 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(43261596));
    }

    static class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32 && n != 0; i++) {
                ans += (n & 1) << (31 - i);
                n = n >>> 1;
            }
            return ans;
        }
    }
}
