package leetcode;

import java.util.Arrays;


public class Tests {

    public static void main(String[] args) {
        int[] dataList = new int[]{13,46,8,11,20,17,40,13,13,13,14,1,13,36,48,41,13,13,13,13,45,13,28,42,13,10,15,22,13,13,13,13,23,9,6,13,47,49,16,13,13,39,35,13,32,29,13,25,30,13};
        int result = findDuplicate(dataList);
        System.out.println(result);
    }


    public static int findDuplicate(int[] nums) {
        long index = 0;
        for (int num : nums) {
            if((index & (1L << num)) != 0) {
                return num;
            }
            index = index | (1L << num);
        }
        return -1;
    }

}
