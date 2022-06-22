package leetcode.search;

import java.util.List;

public class $139 {

    public static void main(String[] args) {
        System.out.println(new $139().wordBreak("leetcode", List.of("leet", "code")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if(i >= len && s.substring(i-len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }
}
