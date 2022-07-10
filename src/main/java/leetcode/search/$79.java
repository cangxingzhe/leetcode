package leetcode.search;

import java.util.concurrent.atomic.AtomicBoolean;

public class $79 {
    public static void main(String[] args) {
        System.out.println(new $79().exist(
                new char[][]{
                        new char[]{'A', 'B', 'C', 'E'},
                        new char[]{'S', 'F', 'C', 'S'},
                        new char[]{'A', 'D', 'E', 'E'}
                },"ABCCED"
        ));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        AtomicBoolean find = new AtomicBoolean(false);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, 0, m, n, visited, find, word);
                if(find.get()) {
                    return find.get();
                }
            }
        }
        return find.get();
    }

    private int[] directions = {-1, 0, 1, 0, -1};

    private void dfs(char[][] board, int i, int j, int pos, int m, int n,
                     boolean[][] visited,
                     AtomicBoolean find,
                     String word) {
        if (find.get() || visited[i][j] || board[i][j] != word.charAt(pos)) {
            return;
        }
        if (pos == word.length() - 1 && board[i][j] == word.charAt(pos)) {
            find.set(true);
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newRow = i + directions[k];
            int newCol = j + directions[k + 1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                dfs(board, newRow, newCol, pos + 1, m, n, visited, find, word);
            }
        }
        visited[i][j] = false;

    }
}
