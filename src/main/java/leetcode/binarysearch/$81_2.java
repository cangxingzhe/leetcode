package leetcode.binarysearch;

public class $81_2 {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return true;
            }else if(nums[left] == nums[mid]) {
                left++;
            }else if(nums[mid] > nums[left]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }
        return false;
    }
}
