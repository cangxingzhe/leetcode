package leetcode.search;

public class $547 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1,0,0,1},
                new int[]{0,1,1,0},
                new int[]{0,1,1,1},
                new int[]{1,0,1,1}
        };
        System.out.println(new $547().findCircleNum(grid));
    }

    public int findCircleNum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[grid.length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            if(!visited[i]) {
                dfs(grid, i, visited);
                count++;
            }
        }
        return count;
    }


    private void dfs(int[][] grid, int i, boolean[] visited) {
        visited[i] = true;
        for (int j = 0; j < grid.length; j++) {
            if(grid[i][j] == 1 && !visited[j]) {
                dfs(grid, j, visited);
            }
        }
    }
}
