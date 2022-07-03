package leetcode.sort;

import java.util.*;

public class $347 {


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,4};
        System.out.println(Arrays.toString(new $347().topKFrequent(nums, 2)));

    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int maxCount = 0;
        for (int num : nums) {
            int i = counts.getOrDefault(num, 0);
            counts.put(num, i+1);
            maxCount = Math.max(maxCount, i+1);
        }

        List<List<Integer>> buckets = new ArrayList<>(maxCount+1);
        for (int i = 0; i < (maxCount + 1); i++) {
            buckets.add(new ArrayList<>());
        }
        counts.forEach((key, value) -> {
            List<Integer> e = buckets.get(value);
            if(e == null) {
                e = new ArrayList<>();
                buckets.add(value, e);
            }
            e.add(key);
        });

        int[] results = new int[k];
        int c = 0;
        int j = 0;
        for(int i=maxCount; i>=0 && c < k; --i) {
            for (Integer integer : buckets.get(i)) {
                results[j] = integer;
                c++;
                j++;
                if(c == k) {
                    break;
                }
            }
        }
        return results;
    }
}
