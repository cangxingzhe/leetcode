package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class $51 {

    public static void main(String[] args) {
        System.out.println(new $51().solveNQueens(1));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>(n);
        if(n == 0) {
            return results;
        }
        List<char[]> result = new ArrayList<>(n);
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int i = 0; i < n; i++) {
            result.add(Arrays.copyOf(chars, n));
        }
        boolean[] columns = new boolean[n];
        boolean[] lDiag = new boolean[2*n - 1];
        boolean[] rDiag = new boolean[2*n - 1];

        dfs(n, 0, columns, lDiag, rDiag, results, result);


        return results;
    }

    private void dfs(int n, int row, boolean[] columns, boolean[] lDiag, boolean[] rDiag,
                     List<List<String>> results, List<char[]> result) {
        if(row == n) {
            List<String> t = new ArrayList<>(n);
            for (char[] chars : result) {
                t.add(new String(chars));
            }
            results.add(t);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(columns[i] || lDiag[n-1+(i-row)] || rDiag[i+row]) {
                continue;
            }
            result.get(row)[i] = 'Q';
            columns[i] = lDiag[n-1+(i-row)] = rDiag[i+row] = true;
            dfs(n, row+1, columns, lDiag, rDiag, results, result);
            columns[i] = lDiag[n-1+(i-row)] = rDiag[i+row] = false;
            result.get(row)[i] = '.';
        }


    }
}
