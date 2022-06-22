package leetcode.dynamicprogramming;

import java.util.Arrays;

public class $322 {

    public static void main(String[] args) {
        System.out.println(new $322().coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0) {
            return -1;
        }
        int[][] dp = new int[amount+1][n+1];
        for (int i = 0; i < amount+1; i++) {
            Arrays.fill(dp[i], amount+2);

        }
        for (int j = 0; j <= amount; j++) {
            for (int i = 1; i <= n; i++) {
                int coin = coins[i-1];
                if(j >= coin) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coin]+1);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

}
