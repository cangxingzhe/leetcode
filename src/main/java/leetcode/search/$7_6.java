package leetcode.search;

import java.util.List;

public class $7_6 {
    public static void main(String[] args) {

    }


    public int knapsack(int[] weights, int[] values, int N, int W) {
        // dp[i][j] 表示前 i 件物品体积不超过 j 的情况下能达到的最大价值
        int[][] dp = new int[N+1][W+1];
        for (int i = 1; i <= N; i++) {
            int weight = weights[i], value = values[i];
            for (int j = 1; j <= W; j++) {
                if(j >= weight) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight] + value);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
