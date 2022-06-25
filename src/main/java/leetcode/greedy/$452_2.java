package leetcode.greedy;

import java.util.Arrays;

public class $452_2 {

    public static void main(String[] args) {
        /*System.out.println(new $452_2().findMinArrowShots(new int[][]{new int[]{10, 16},
                new int[]{2, 8},
                new int[]{1, 6},
                new int[]{7, 12}
        }));
        System.out.println(new $452_2().findMinArrowShots(new int[][]{new int[]{1, 2},
                new int[]{3, 4}, new int[]{5, 6}, new int[]{7, 8}
        }));*/
        System.out.println(new $452_2().findMinArrowShots(new int[][]{new int[]{-2147483646,-2147483645},
                new int[]{2147483646,2147483647}
        }));

    }

    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len <= 1) {
            return len;
        }
        Arrays.sort(points, (x, y) -> {
            if(x[0] == y[0]) {
                return Integer.compare(x[1], y[1]);
            }
            return Integer.compare(x[0], y[0]);
        });

        int left = points[0][0];
        int right = points[0][1];
        int count = 1;
        for (int i = 1; i < len; i++) {
            if(right >= points[i][0]) {
                left = Math.max(points[i][0], left);
                right = Math.min(points[i][1], right);
            }else {
                count++;
                left = points[i][0];
                right = points[i][1];
            }
        }
        return count;

    }

}
