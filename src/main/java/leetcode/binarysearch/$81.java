package leetcode.binarysearch;

public class $81 {

    public static void main(String[] args) {
        System.out.println(new $81().search(new int[]{3,5,1}, 3));
    }

    public boolean search(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[l] == nums[mid]) {
                l++;
            }else if(nums[mid] <= nums[r]) {
                if(target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if(target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}
