package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目描述
 *   给定多个区间，计算让这些区间互不重叠所需要移除区间的最少个数。起止相连不算重叠。
 */
public class $435 {
    public static void main(String[] args) {
        int[][] input = new int[][]{
                new int[]{1, 2},
                new int[]{2, 4},
                new int[]{1, 3},
        };
        int result = eraseOverlapIntervals(input);
        System.out.println(result);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int size = intervals.length;
        if(size == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int total = 0, prev = intervals[0][1];
        for (int i=1; i<intervals.length; i++) {
            if(intervals[i][0] < prev) {
                total++;
            }else {
                prev = intervals[i][1];
            }
        }
        return total;
    }
}
