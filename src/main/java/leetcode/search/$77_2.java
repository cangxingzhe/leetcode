package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class $77_2 {

    public static void main(String[] args) {
        System.out.println(new $77_2().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        dfs(n, 1, 0, k, results, result);
        return results;

    }

    private void dfs(int n, int pos, int count, int k, List<List<Integer>> results, List<Integer> result) {
        if(count == k) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = pos; i <= n; i++) {
            result.add(i);
            count++;
            dfs(n, i + 1, count, k, results, result);
            result.remove(result.size()-1);
            count--;
        }

    }
}
