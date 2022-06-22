package leetcode.math;

import java.util.Arrays;
import java.util.Random;

public class $384 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new $384(new int[]{1, 2, 3}).shuffle()));
    }

    private int[] origins;
    public $384(int[] nums) {
        origins = nums;
    }

    public int[] reset() {
        return origins;
    }
    Random random = new Random();
    public int[] shuffle() {
        int[] ans = origins.clone();
        int n = origins.length;
        for (int i = 0; i < n; i++) {
            swap(ans, i, i + random.nextInt(n-i));
        }
        return ans;
    }

    private void swap(int[] ans, int i, int j) {
        int temp = ans[i];
        ans[i] = ans[j];
        ans[j] = temp;
    }
}
