package leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class $46_2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, results);
        return results;
    }

    private void dfs(int[] nums, int level, List<List<Integer>> results) {
        if(level == nums.length - 1) {
            List<Integer> result = new ArrayList<>();
            for (int num : nums) {
                result.add(num);
            }
            results.add(result);
            return;
        }
        for (int k = level; k < nums.length; k++) {
            swap(nums, level, k);
            dfs(nums, level+1, results);
            swap(nums, k, level);
        }

    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] =temp;
    }
}
