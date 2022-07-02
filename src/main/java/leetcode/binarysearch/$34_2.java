package leetcode.binarysearch;

import java.util.Arrays;

public class $34_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $34_2().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[]{-1, -1};
        int targetIndex = -1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                targetIndex = mid;
                break;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(targetIndex == -1) {
            return result;
        }
        if(nums[targetIndex] == target) {
            left = targetIndex;
            right = targetIndex;
            while(left >= 0 && nums[left] == target) {
                result[0] = left;
                left--;
            }
            while(right < nums.length && nums[right] == target) {
                result[1] = right;
                right++;
            }
        }
        return result;
    }
}
