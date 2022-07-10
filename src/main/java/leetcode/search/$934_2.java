package leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

public class $934_2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        new int[]{0,1,0},
                        new int[]{0,0,0},
                        new int[]{0,0,1}
                };
        System.out.println(new $934_2().shortestBridge(grid));
    }

    public int shortestBridge(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean finded = false;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if(finded) {
                break;
            }
            for (int j = 0; j < n; j++) {
               if(grid[i][j] == 1) {
                   dfs(grid, m, n, i, j, queue);
                   finded = true;
                   break;
               }
            }
        }
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size != 0) {
                size--;
                int[] pos = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newRow = pos[0] + directions[k];
                    int newCol = pos[1] + directions[k + 1];
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        if(grid[newRow][newCol] == 2) {
                        }else if(grid[newRow][newCol] == 1) {
                            return level;
                        }else {
                            grid[newRow][newCol] = 2;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        return level;

    }

    int[] directions = {-1, 0, 1, 0, -1};
    private void dfs(int[][] grid, int m, int n, int i, int j, Queue<int[]> queue) {
        if(grid[i][j] == 2) {
            return;
        }
        if(grid[i][j] == 0) {
            queue.offer(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            int newRow = i + directions[k];
            int newCol = j + directions[k + 1];
            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                dfs(grid, m, n, newRow, newCol, queue);
            }
        }


    }
}
