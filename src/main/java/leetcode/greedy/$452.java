package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class $452 {

    public static void main(String[] args) {
        System.out.println(new $452().findMinArrowShots(new int[][]{new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12}
        }));
        System.out.println(new $452().findMinArrowShots(new int[][]{new int[]{1, 2},
                new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}
        }));
        System.out.println(new $452().findMinArrowShots(new int[][]{new int[]{1, 2}
        }));
        System.out.println(new $452().findMinArrowShots(new int[][]{new int[]{2, 3}, {2, 3}
        }));
        System.out.println(new $452().findMinArrowShots(new int[][]{new int[]{1,2},{2,3},{3,4},{4,5}
        }));
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int minValue = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= minValue) {
                if (points[i][1] < minValue) {
                    minValue = points[i][1];
                }
            } else {
                count++;
                minValue = points[i][1];
            }
        }
        return count;
    }
}
