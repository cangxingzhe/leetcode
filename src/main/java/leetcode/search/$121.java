package leetcode.search;

public class $121 {

    public static void main(String[] args) {
        System.out.println(new $121().maxProfit2(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int sell = 0, minPrize = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrize = Math.min(minPrize, price);
            sell = Math.max(sell, price - minPrize);
        }
        return sell;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[][] dp = new int[n][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        return dp[n-1][0];
    }
}
