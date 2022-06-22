package leetcode.search;

public class $343 {

    public static void main(String[] args) {
        System.out.println(new $343().integerBreak(2));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for(int j=1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), dp[i - j] * j));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
