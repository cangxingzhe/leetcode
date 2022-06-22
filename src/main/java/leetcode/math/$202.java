package leetcode.math;

public class $202 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(~1));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(~1);
        System.out.println(4&1);
        System.out.println(new Solution().isHappy(19));
    }

    static class Solution {
        public boolean isHappy(int n) {
            int slow = n, fast = squareSum(n);
            while(slow != fast) {
                slow = squareSum(slow);
                fast = squareSum(squareSum(fast));
            }
            return slow == 1;
        }

        private int squareSum(int n) {
            int sum = 0;
            while(n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            return sum;
        }
    }
}
