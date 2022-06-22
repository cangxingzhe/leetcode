package leetcode.search;

public class $416 {

    public static void main(String[] args) {

    }

    /*public boolean canPartition(int[] nums) {
        int n = nums.length;
        if(n <= 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        //  dp[i][j] 表示从数组的 [0,i][0,i] 下标范围内选取若干个正整数（可以是 00 个），是否存在一种选取方案使得被选取的正整数的和等于 jj
        int target = sum >> 2;
        for (int i = 1; i <= n; i++) {
            for (int j = nums[i-1]; j <= target; j++) {

            }
        }

    }*/
}
