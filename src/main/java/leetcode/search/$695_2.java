package leetcode.search;

public class $695_2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new $695_2().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, depth(grid, i, j));
                }
            }
        }
        return max;
    }

    int[] directions = {-1, 0, 1, 0, -1};
    private int depth(int[][] grid, int i, int j) {
        if(i < 0 || grid.length <= i || j < 0 || grid[i].length <= j || grid[i][j] == 0) {
            return 0;
        }
        int sum = 1;
        grid[i][j] = 0;
        for (int k = 0; k < 4; k++) {
            sum += depth(grid, i + directions[k], j + directions[k+1]);
        }
        return sum;
    }
}
