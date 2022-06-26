package leetcode.doublepointer;

import java.util.Arrays;

public class $88_2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        new $88_2().merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int position = nums1.length-1;
        m--;
        n--;
        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[position--] = nums1[m--];
            }else {
                nums1[position--] = nums2[n--];
            }
        }
       /* while(m > 0) {
            nums1[position--] = nums2[m--];
        }*/
        while(n >= 0) {
            nums1[position--] = nums2[n--];
        }
    }
}
