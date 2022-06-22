package leetcode.search;

public class $583 {
    public static void main(String[] args) {
        System.out.println(new $583().minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }else if(j == 0) {
                    dp[i][j] = i;
                }else {
                    if(word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
