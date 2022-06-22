package leetcode.search;

public class $213 {
    public static void main(String[] args) {
        System.out.println(new $213().rob(new int[]{200,3,140,20,10}));
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if(length == 1) {
            return nums[0];
        }
        if(length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length-1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }
}
