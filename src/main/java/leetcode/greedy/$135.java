package leetcode.greedy;

import java.util.Arrays;

/**
 * 题目描述
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，
 * 规则是如果一 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果;
 * 所 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 */
public class $135 {

    public static int candy(int[] ratings) {
        int size = ratings.length;
        int[] results = new int[ratings.length];
        Arrays.fill(results, 1);
        for(int i=1; i<size; ++i) {
            if(ratings[i] > ratings[i-1]) {
                results[i] = results[i-1]+1;
            }
        }
        for(int i=size-1; i>0; --i) {
            if(ratings[i-1] > ratings[i]) {
                results[i-1] = Math.max(results[i-1], results[i]+1);
            }
        }
        int count = 0;
        for (int result : results) {
            count += result;
        }
        return count;
    }

    public static void main(String[] args) {
        int result = candy(new int[]{1,2,87,87,87,2,1});
        System.out.println(result);
    }
}
