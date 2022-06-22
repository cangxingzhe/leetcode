package leetcode.search;

public class $474 {
    public static void main(String[] args) {
        System.out.println(new $474().findMaxForm2(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int k = 1; k <= strs.length; k++) {
            int[] oneAndZeros = findOneAndZeros(strs[k-1]);
            int zeros = oneAndZeros[0], ones = oneAndZeros[1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[k][i][j] = dp[k-1][i][j];
                    if(zeros <= i && ones <= j) {
                        dp[k][i][j] = Math.max(dp[k][i][j], dp[k-1][i-zeros][j-ones]+1);
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int k = 1; k <= strs.length; k++) {
            int[] oneAndZeros = findOneAndZeros(strs[k-1]);
            int zeros = oneAndZeros[0], ones = oneAndZeros[1];
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    dp[i][j] = dp[i][j];
                    if(zeros <= i && ones <= j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] findOneAndZeros(String str) {
        int[] result = new int[2];
        for (int i = 0; i < str.length(); i++) {
            result[str.charAt(i) - '0']++;
        }
        return result;
    }
}
