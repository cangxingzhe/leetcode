package leetcode.dynamicprogramming;

public class $413 {
    public static void main(String[] args) {
        System.out.println(new $413().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            return 0;
        }
        int d = nums[1] - nums[0];
        int t = 0;
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if(nums[i] - nums[i-1] == d) {
                t++;
            }else {
                d = nums[i] - nums[i-1];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
