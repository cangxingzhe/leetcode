package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

public class $763_2 {

    public static void main(String[] args) {
        List<Integer> result = new $763_2().partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String s) {
        int[] counts = new int[26];
        char[] sArray = s.toCharArray();
        for (int i = 0; i < sArray.length; i++) {
            counts[sArray[i] - 'a'] = i;
        }
        int maxPosition = 0;
        int startPosition = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sArray.length; i++) {
            int curPosition = counts[sArray[i] - 'a'];
            if(curPosition == i && maxPosition <= i) {
                result.add(i - startPosition + 1);
                startPosition = i+1;
            }else {
                if(maxPosition < curPosition) {
                    maxPosition = curPosition;
                }
            }
        }
        return result;
    }

}
