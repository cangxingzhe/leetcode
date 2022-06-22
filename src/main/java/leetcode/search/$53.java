package leetcode.search;

public class $53 {
    public static void main(String[] args) {
        System.out.println(new $53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int num : nums) {
            pre = Math.max(num, pre + num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
