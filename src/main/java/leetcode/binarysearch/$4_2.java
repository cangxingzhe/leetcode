package leetcode.binarysearch;

public class $4_2 {

    public static void main(String[] args) {
        System.out.println(new $4_2().findMedianSortedArrays(
                new int[]{1,2},
                new int[]{3,4}
        ));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] results = new int[m+n];
        int k = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                results[k++] = nums1[i];
                i++;
            }else {
                results[k++] = nums2[j];
                j++;
            }
        }
        while(i < m) {
            results[k++] = nums1[i++];
        }
        while(j < n) {
            results[k++] = nums2[j++];
        }
        int mid = k/2;
        if(k % 2 == 1) {
            return results[mid];
        }else {
            return (((double)results[mid] + (double)results[mid-1]))/2;
        }
    }
}
