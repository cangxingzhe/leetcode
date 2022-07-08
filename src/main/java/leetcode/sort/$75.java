package leetcode.sort;

import java.util.Arrays;

public class $75 {

    public static void main(String[] args) {
        int[] array = new int[]{2,0,2,1,1,0};
        new $75().sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while(i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
            if(i <= p2 && nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                p0++;
            }
        }
    }
}
