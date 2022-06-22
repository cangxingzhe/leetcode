package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/solution/cdong-tai-gui-hua-er-fen-fa-tan-xin-fa-yi-ti-duo-j/
 */
public class $646 {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{
                new int[]{-6,9},
                new int[]{1,6},
                new int[]{8,10},
                new int[]{-1,4},
                new int[]{-6,-2},
                new int[]{-9,8},
                new int[]{-5,3},
                new int[]{0,3}
            };
        System.out.println(new $646().findLongestChain2(pairs));
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int findLongestChain2(int[][] pairs) {
        int n = pairs.length;
        if(n == 0) {
            return 0;
        }
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? (a[1] - b[1]) : (a[0] - b[0]));
        List<Integer[]> dp = new ArrayList<>();

        for (int[] pair : pairs) {
            int l = 0, r = dp.size();
            while(l < r) {
                int mid = l + ((r - l) >> 1);
                if(dp.get(mid)[1] >= pair[0]) {
                    r = mid;
                }
                else {
                    l = mid + 1;
                }
            }
            if(l >= dp.size()) {
                dp.add(Arrays.stream(pair).boxed().toArray(Integer[]::new));
            }
            else if(dp.get(l)[1] > pair[1]) {
                dp.set(l, Arrays.stream(pair).boxed().toArray(Integer[]::new));
            }
        }
        return dp.size();
    }

    public int findLongestChain3(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int cur = pairs[0][1], ans = 1;
        for (int[] pair : pairs) {
            if(cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }
        return ans;
    }
}
