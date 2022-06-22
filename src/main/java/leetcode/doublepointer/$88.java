package leetcode.doublepointer;

import java.util.Arrays;

public class $88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        new $88().merge(nums1, 3, new int[]{-1,1,1,1,2,3}, 6);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m-- + n -- - 1;
        while(m >= 0 || n >= 0) {
            int v1 = m < 0 ? Integer.MIN_VALUE : nums1[m];
            int v2 = n < 0 ? Integer.MIN_VALUE : nums2[n];
            if(v1 >= v2) {
                nums1[pos] = v1;
                m--;
            }else {
                nums1[pos] = v2;
                n--;
            }
            pos--;
        }


    }
}
