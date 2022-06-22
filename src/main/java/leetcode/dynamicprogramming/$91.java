package leetcode.dynamicprogramming;

import java.util.Arrays;

public class $91 {

    public static void main(String[] args) {
        System.out.println(new $91().numDecodings("226"));
    }

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        char[] words = s.toCharArray();
        int pre = words[0] - '0';
        if(pre == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            int cur = words[i-1] - '0';
            if((pre == 0 || pre > 2) && cur == 0) {
                return 0;
            }
            if((pre == 1) || (pre == 2 && cur < 7)) {
                if(cur != 0) {
                    dp[i] = dp[i-2] + dp[i-1];
                }else {
                    dp[i] = dp[i-2];
                }
            }else {
                dp[i] = dp[i-1];
            }
            pre = cur;
        }
        return dp[n];
    }
}
