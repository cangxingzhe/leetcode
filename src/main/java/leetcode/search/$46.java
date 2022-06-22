package leetcode.search;

import java.util.ArrayList;
import java.util.List;

public class $46 {

    public static void main(String[] args) {
        System.out.println(new $46().permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        backtracking(nums, 0, answers);
        return answers;
    }

    private void backtracking(int[] nums, int level, List<List<Integer>> answers) {
        if(level == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int num : nums) {
                list.add(num);
            }
            answers.add(list);
            return;
        }
        for(int i=level; i<nums.length; i++) {
            swap(nums, level, i);
            backtracking(nums, level+1, answers);
            swap(nums, level, i);
        }
    }

    private void swap(int[] x, int a, int b) {
        int t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
