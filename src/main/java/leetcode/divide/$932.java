package leetcode.divide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class $932 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString((new $932().beautifulArray(3))));
    }

    Map<Integer, int[]> memo;
    public int[] beautifulArray(int N) {
        memo = new HashMap<>();
        memo.put(1, new int[]{1});
        return f(N);
    }

    private int[] f(int N){
        if(!memo.containsKey(N)){
            int index = 0;
            int[] res = new int[N];
            for(int x : f((N + 1) / 2)){
                res[index++] = 2 * x - 1;
            }
            for(int x : f(N / 2)){
                res[index++] = 2 * x;
            }
            memo.put(N, res);
        }
        return memo.get(N);
    }
}
