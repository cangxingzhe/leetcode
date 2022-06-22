package leetcode.doublepointer;

import java.util.Arrays;

public class $167 {

    public static void main(String[] args) {
        int[] numbers = new int[]{3,24,50,79,88,150,345};
        System.out.println(Arrays.toString(new $167().twoSum(numbers, 200)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum = 0;
        while(i < j) {
            sum = numbers[i] + numbers[j];
            if(sum == target) {
                break;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i+1, j+1};

    }
}
