package leetcode.search;

import java.util.Arrays;

public class $300 {
    public static void main(String[] args) {
        System.out.println(new $300().lengthOfLIS2(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS(int[] nums) {
        int maxLength = 0, n = nums.length;
        if(n <= 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }


    public int lengthOfLIS2(int[] nums) {
        int len = 1, n = nums.length;
        if(n <= 1) return n;
        int[] dp = new int[n+1];
        dp[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if(dp[len] < nums[i]) {
                dp[++len] = nums[i];
            }else {
                int l = 1, r = len, pos = 0;
                while(l <= r) {
                    int mid = (l + r) >> 1;
                    if(dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid+1;
                    }else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
