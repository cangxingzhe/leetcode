package leetcode;

import java.util.Arrays;

public class $283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new $283().moveZero(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZero(int[] nums) {
        int idx = 0;
        for (int num : nums) {
            if(num != 0) {
                nums[idx++] = num;
            }
        }
        while(idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}
