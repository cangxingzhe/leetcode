package leetcode.math;

public class $462 {

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves2(new int[]{1,2,3}));
    }

    static class Solution {
        private int select(int[] nums, int l, int r, int k) {
            if(l == r) {
                return nums[l];
            }
            int pivotIndex = partition(nums, l, r);
            if(k == pivotIndex) {
                return nums[k];
            }else if(k < pivotIndex) {
                return select(nums, l, pivotIndex - 1, k);
            }else {
                return select(nums, pivotIndex + 1, r, k);
            }
        }

        private int partition(int[] nums, int l, int r) {
            int i,j,x;
            i = l;
            j = r;
            x = nums[i];
            while (i < j) {
                while(i < j && nums[j] > x)
                    j--; // 从右向左找第一个小于x的数
                if(i < j)
                    nums[i++] = nums[j];
                while(i < j && nums[i] < x)
                    i++; // 从左向右找第一个大于x的数
                if(i < j)
                    nums[j--] = nums[i];
            }
            nums[i] = x;
            return i;
        }

        public int minMoves2(int[] nums) {
            int sum = 0;
            int median = select(nums, 0, nums.length-1, nums.length/2);
            for (int num : nums) {
                sum += Math.abs(num - median);
            }
            return sum;
        }
    }
}
