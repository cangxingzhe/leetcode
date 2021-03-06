package leetcode.greedy;

import java.util.Arrays;

public class $135_2 {

    public static void main(String[] args) {
        System.out.println(new $135_2().candy(new int[]{1,2,87,87,87,2,1}));
    }

    public int candy(int[] ratings) {
        int[] results = new int[ratings.length];
        Arrays.fill(results, 1);
        for (int i = 1; i < results.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                results[i] = results[i-1] + 1;
            }
        }
        for (int i = results.length-1; i > 0 ; i--) {
            if(ratings[i-1] > ratings[i] ) {
                results[i-1] = Math.max(results[i]+1, results[i-1]);
            }
        }

        int sum = 0;
        for (int result : results) {
            sum += result;
        }
        return sum;
    }
}
