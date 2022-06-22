package leetcode.math;

import java.util.Arrays;

public class $169 {

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    static class Solution {
        public int majorityElement(int[] nums) {
            int canNum = nums[0], count = 1;
            for (int i = 1; i < nums.length; i++) {
                if(canNum == nums[i]) {
                    count++;
                }else if(--count == 0) {
                    canNum = nums[i];
                    count = 1;
                }
            }
            return canNum;
        }
    }
}
