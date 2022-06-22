package leetcode.search;

public class $309 {

    public static void main(String[] args) {
        System.out.println(new $309().maxProfit(new int[]{1,2,3,0,2}));
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        int[] buy  = new int[n], s1  = new int[n], sell = new int[n], s2 = new int[n];
        // 持股
        buy[0] = s1[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 当前持股收益，购买
            buy[i] = s2[i-1] - prices[i];
            //  在第 i 天结束之后不持有任何股票并且不处于冷冻期
            s1[i] = Math.max(s1[i-1], buy[i-1]);
            // 卖出股票，处于冷冻期，要求在第 i−1 天时持有一支股票
            sell[i] = Math.max(buy[i-1], s1[i-1]) + prices[i];
            // 在第 i 天结束之后不持有任何股票并且不处于冷冻期
            // 必须没有进行任何操作：如果处于冷冻期，对应sell[i-1]，如果不处于冷冻期，对应s2[i-1]
            s2[i] = Math.max(s2[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1], s2[n-1]);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) {
            return 0;
        }
        int[] buy = new int[n], sell = new int[n], cold = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 手上持有股票的最大收益
            buy[i] = Math.max(buy[i-1], cold[i-1] - prices[i]);
            // 手上不持有股票，并且处于冷冻期中的累计最大收益
            sell[i] = buy[i-1] + prices[i];
            // 手上不持有股票，并且不在冷冻期中的累计最大收益
            cold[i] = Math.max(cold[i-1], sell[i-1]);
        }
        return Math.max(sell[n-1], cold[n-1]);
    }
}
