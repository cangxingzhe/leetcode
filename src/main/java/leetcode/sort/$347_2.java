package leetcode.sort;

import java.util.*;
import java.util.stream.Collectors;

public class $347_2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,4};
        System.out.print(Arrays.toString(new $347_2().topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap();
        int maxCount = 0;
        for (int num : nums) {
            int preCount = counts.getOrDefault(num, 0);
            preCount++;
            counts.put(num, preCount);
            maxCount = Math.max(maxCount, preCount);
        }

        List<List<Integer>> buckets = new ArrayList(maxCount+1);
        for (int i = 0; i < (maxCount + 1); i++) {
            buckets.add(new ArrayList<>());
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            List<Integer> preValue = buckets.get(entry.getValue());
            preValue.add(entry.getKey());
        }
        List<Integer> results = new ArrayList<>();
        int[] ans = new int[k];
        int c = 0;
        for (int i = maxCount; i > 0; i--) {
            List<Integer> preValue = buckets.get(maxCount);
            if(preValue != null && preValue.size() != 0) {
                for (Integer value : preValue) {
                    results.add(value);
                    c++;
                    if(c == k) {
                        for (int j = 0; j < results.size(); j++) {
                            ans[j] = results.get(j);
                        }
                        break;
                    }
                }
            }

        }
        return ans;
    }
}
