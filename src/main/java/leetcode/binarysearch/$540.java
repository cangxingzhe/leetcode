package leetcode.binarysearch;

public class $540 {

    public static void main(String[] args) {
        System.out.println(new $540().singleNonDuplicate(new int[]{1,2,2,3,3}));
    }

    /**
     * log(n)
     */
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length - 1) {
                if((nums[i] != nums[i-1]))
                    return nums[i];
            }else if(i == 0) {
                if((nums[i] != nums[i+1]))
                    return nums[i];
            }else {
                if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
