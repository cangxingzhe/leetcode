package leetcode.bitoperation;

public class $342 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour2(3));
    }

    static class Solution {
        public boolean isPowerOfFour(int n) {
            if(n < 0) {
                return false;
            }
            while(n > 1) {
                if(n % 4 != 0) {
                    return false;
                }
                n /= 4;
            }
            return n == 1;
        }

        public boolean isPowerOfFour2(int n) {
            return n > 0 && (n & (n-1)) == 0 && (n & 0xaaaaaaaa) == 0;
        }
    }
}
