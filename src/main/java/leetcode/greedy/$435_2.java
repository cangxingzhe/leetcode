package leetcode.greedy;

import java.util.Arrays;

public class $435_2 {

    public static void main(String[] args) {
        $435_2 that = new $435_2();
        System.out.println(that.eraseOverlapIntervals(
                new int[][] {
                        new int[]{1,2},
                        new int[]{2,3},
                        new int[]{3,4},
                        new int[]{1,3}
                }
        ));
        System.out.println(that.eraseOverlapIntervals(
                new int[][] {
                        new int[]{0,2},
                        new int[]{1,3},
                        new int[]{2,4},
                        new int[]{3,5},
                        new int[]{4,6}
                }
        ));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        int right = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < right) {
                count++;
                if(right > intervals[i][1]) {
                    right = intervals[i][1];
                }
            }else {
                right = intervals[i][1];
            }

        }
        return count;
    }
}
