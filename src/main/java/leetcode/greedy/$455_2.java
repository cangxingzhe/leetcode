package leetcode.greedy;

import java.util.*;

public class $455_2 {

    public static void main(String[] args) {
        int result = new $455_2().findContentChildren(new int[]{10,9,8,7}, new int[]{5,6,7,8});
        System.out.println(result);
    }

    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        List<Integer> gList = order(g);
        List<Integer> sList = order(s);
        int i = 0;
        int j = 0;
        int m = g.length;
        int n = s.length;

        while(i < m && j < n) {
            if(gList.get(i) <= sList.get(j)) {
                i++;
                j++;
                count++;
            }else {
                i++;
            }
        }
        return count;
    }

    private List<Integer> order(int[] a) {
        List<Integer> result = new ArrayList<>();
        for (int i : a) {
            result.add(i);
        }
        result.sort(Comparator.reverseOrder());
        return result;
    }
}
