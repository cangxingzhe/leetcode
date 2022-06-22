package leetcode.dynamicprogramming;

public class $474 {

    public static void main(String[] args) {
        System.out.println(new $474().findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][][] dp = new int[length+1][m+1][n+1];
        for (int i = 1; i <= length; i++) {
            int[] oneAndZero = findOneAndZero(strs[i-1]);
            int zero = oneAndZero[0];
            int one = oneAndZero[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if(zero <= j && one <= k) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zero][k-one] + 1);
                    }else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private int[] findOneAndZero(String str) {
        int[] results = new int[2];
        for (char c : str.toCharArray()) {
            results[c - '0']++;
        }
        return results;
    }
}
