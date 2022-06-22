package leetcode.search;

public class $695 {

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
        System.out.println(new $695().maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    int[] directions = new int[]{-1,0,1,0,-1};

    private int dfs(int[][] grid, int r, int c) {
        if(grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int dfs = 1;
        for (int i = 0; i < 4; i++) {
            int x = r + directions[i];
            int y = c + directions[i+1];
            if(x >=0 && x < grid.length && y >=0 && y < grid[0].length)
            dfs += dfs(grid, x, y);
        }
        return dfs;
    }
}
