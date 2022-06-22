package leetcode.binarysearch;

public class $154 {

    public static void main(String[] args) {
        //System.out.println(new $154().findMin(new int[]{1,3,5}));
        System.out.println(new $154().findMin(new int[]{2,2,2,0,1}));
    }

    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Math.min(nums[l], nums[r]);
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(nums[l] == nums[mid]) {
                min = Math.min(min, nums[mid]);
                l++;
            }else if(nums[mid] <= nums[r]){
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }else {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
        }
        return min;
    }
}
