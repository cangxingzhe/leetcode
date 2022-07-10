package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class $417 {

    public static void main(String[] args) {
        System.out.println(new $417().pacificAtlantic(
                new int[][]{
                        new int[]{1, 2, 2, 3, 5},
                        new int[]{3, 2, 3, 4, 4},
                        new int[]{2, 4, 5, 3, 1},
                        new int[]{6, 7, 1, 4, 5},
                        new int[]{5, 1, 1, 2, 4}
                }
        ));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, p, m, n);
        }
        for (int i = 1; i < n; i++) {
            dfs(heights, 0, i, p, m, n);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, a, m, n);
        }
        for (int i = 0; i < n - 1; i++) {
            dfs(heights, m - 1, i, a, m, n);
        }
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> result = new ArrayList<>();
                    result.add(i);
                    result.add(j);
                    results.add(result);
                }
            }
        }
        return results;
    }

    int[] directions = {-1, 0, 1, 0, -1};

    private void dfs(int[][] heights, int i, int j, boolean[][] flag, int m, int n) {
        if (flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newI = i + directions[k];
            int newJ = j + directions[k+1];
            if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && heights[newI][newJ] >= heights[i][j]) {
                dfs(heights, newI, newJ, flag, m, n);
            }
        }

    }
}
