package leetcode.binarysearch;

public class $154_2 {

    public static void main(String[] args) {
        System.out.println(new $154_2().findMin(new int[]{0,1,1,1,2,2}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min = Math.min(nums[0], nums[right]);
        while(left <= right) {
            int mid = (left + right)/2;
            min = Math.min(min, nums[mid]);
            if(nums[left] == nums[mid]) {
                left++;
            }else if(nums[left] < nums[mid]) {
                min = Math.min(min, nums[left]);
                left = mid+1;
            }else {
                right = mid - 1;
            }
        }
        return min;
    }
}
