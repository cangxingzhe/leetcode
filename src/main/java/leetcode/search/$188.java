package leetcode.search;

import java.util.Arrays;

public class $188 {
    public static void main(String[] args) {
        System.out.println(new $188().maxProfit2(2, new int[]{2,4,1}));
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return n;
        }
        if(k > n) {
            return maxProfitUnlimte(prices);
        }
        int[][] buy = new int[n+1][k+1];
        int[][] sell = new int[n+1][k+1];
        Arrays.fill(buy[0], Integer.MIN_VALUE/2);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i-1]);
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j] + prices[i-1]);
            }
        }
        return sell[n][k];

    }

    public int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return n;
        }
        if(k > n) {
            return maxProfitUnlimte(prices);
        }
        int[] buy = new int[k+1];
        int[] sell = new int[k+1];
        Arrays.fill(buy, Integer.MIN_VALUE/2);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i-1]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i-1]);
            }
        }
        return sell[k];

    }

    private int maxProfitUnlimte(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                ans += (prices[i] - prices[i-1]);
            }
        }
        return ans;
    }
}
