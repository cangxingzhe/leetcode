package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class $77 {

    public static void main(String[] args) {
        System.out.println(new $77().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] combo = new int[k];
        backtracking(ans, combo, 0, 1, k,n );
        return ans;
    }

    private void backtracking(List<List<Integer>> ans, int[] combo, int count, int pos, int k, int n) {
        if(count == k) {
            List<Integer> list = new ArrayList<>(k);
            for (int i : combo) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        for(int i=pos; i<=n; i++) {
            combo[count++] = i;
            backtracking(ans, combo, count, i+1, k, n);
            --count;
        }


    }
}
