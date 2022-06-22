package leetcode.math;

import java.util.Arrays;

public class $528 {
    public static void main(String[] args) {
        System.out.println(new Solution(new int[]{1,3}).pickIndex());
        System.out.println(new Solution(new int[]{1,3}).pickIndex());
    }
        static class Solution {
            private int[] powers;
            private int sum;
            public Solution(int[] w) {
                int n = w.length;
                powers = new int[n];
                powers[0] = w[0];
                for (int i = 1; i < n; i++) {
                    powers[i] = powers[i-1] + w[i];
                }
                sum = Arrays.stream(w).sum();
            }

            public int pickIndex() {
                int pickedNum = (int)(Math.random() * sum) + 1;
                int l = 0, r = powers.length - 1;
                while (l < r) {
                    int mid = l + ((r - l) >> 1);
                    if(pickedNum > powers[mid]) {
                        l = mid + 1;
                    }else {
                        r = mid;
                    }
                }
                return l;
            }
        }

}
