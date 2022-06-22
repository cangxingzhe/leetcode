package leetcode.dynamicprogramming;

public class $198 {

    public static void main(String[] args) {
        System.out.println(new $198().rob(new int[]{1,2,3,1}));
    }

    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int cur = 0, pre = 0, prePre = 0;
        for (int num : nums) {
            cur = Math.max(pre, prePre + num);
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
