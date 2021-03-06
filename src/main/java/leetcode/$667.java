package leetcode;

import java.util.Arrays;

public class $667 {

    public static void main(String[] args) {
        var result = new $667().constructArray(3, 2);
        System.out.println(Arrays.toString(result));
        System.out.println(null == null);
    }

    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
