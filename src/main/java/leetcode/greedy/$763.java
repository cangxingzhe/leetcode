package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class $763 {
    public List<Integer> partitionLabels(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a'] = i;
        }
        List<Integer> results = new ArrayList<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(num[s.charAt(i) - 'a'], max);
            count++;
            if(max == i) {
                results.add(count);
                count = 0;
            }
        }
        return results;
    }
    public List<Integer> partitionLabels2(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a'] = i;
        }

        int max = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, num[s.charAt(i) - 'a']);

            if (max == i) {
                res.add(max - start + 1);
                start = max + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = new $763().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
    }
}
