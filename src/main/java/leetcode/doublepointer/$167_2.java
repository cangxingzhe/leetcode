package leetcode.doublepointer;

import java.util.Arrays;

public class $167_2 {

    public static void main(String[] args) {
        int[] numbers = new int[]{3,24,50,79,88,150,345};
        System.out.println(Arrays.toString(new $167_2().twoSum(numbers, 200)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            int total = numbers[l] + numbers[r];
            if(total < target) {
                l++;
            }else if(total > target) {
                r--;
            }else {
                break;
            }
        }
        return new int[]{l+1, r+1};
    }
}
