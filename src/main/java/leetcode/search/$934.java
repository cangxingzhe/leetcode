package leetcode.search;

import java.util.LinkedList;
import java.util.Queue;

public class $934 {

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                    new int[]{0,1,0},
                    new int[]{0,0,0},
                    new int[]{0,0,1}
                };
        System.out.println(new $934().shortestBridge(grid));
    }

    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean flipped = false;
        for (int i = 0; i < grid.length; i++) {
            if (flipped) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(queue, grid, i, j, m, n);
                    flipped = true;
                    break;
                }
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int queueSize = queue.size();
            while (queueSize > 0) {
                Pair pair = queue.poll();
                queueSize--;
                for (int k = 0; k < 4; k++) {
                    int x = pair.i + directions[k];
                    int y = pair.j + directions[k + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (grid[x][y] == 2) {
                            continue;
                        }
                        if (grid[x][y] == 1) {
                            return level;
                        }
                        grid[x][y] = 2;
                        queue.offer(new Pair(x, y));
                    }
                }
            }
        }
        return level;
    }

    private int[] directions = new int[]{-1, 0, 1, 0, -1};

    private void dfs(Queue<Pair> queue, int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == 2) {
            return;
        }
        if (grid[i][j] == 0) {
            queue.offer(new Pair(i, j));
            return;
        }
        grid[i][j] = 2;
        for (int k = 0; k < 4; k++) {
            dfs(queue, grid, i + directions[k], j + directions[k + 1], m, n);
        }
    }

    static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
