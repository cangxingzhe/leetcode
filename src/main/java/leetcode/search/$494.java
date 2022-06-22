package leetcode.search;

public class $494 {
    public static void main(String[] args) {
        System.out.println(new $494().findTargetSumWays2(new int[]{1,1,1,1,1}, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0) return 0;
        int neg = (sum - target) >> 1;
        int n = nums.length;
        int[][] dp = new int[n+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= num) {
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[n][neg];
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if(diff < 0 || diff % 2 != 0) return 0;
        int neg = (sum - target) >> 1;
        int n = nums.length;
        int[] dp = new int[neg+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i-1];
            for (int j = neg; j >= 0; j--) {
                dp[j] = dp[j];
                if(j >= num) {
                    dp[j] += dp[j-num];
                }
            }
        }
        return dp[neg];
    }
}