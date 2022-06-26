package leetcode.greedy;

public class $665_2 {

    public static void main(String[] args) {
        System.out.println(new $665_2().checkPossibility(new int[]{4,2,3}));
        System.out.println(new $665_2().checkPossibility(new int[]{4,2,1}));
    }

    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n <= 2) {
            return true;
        }
        boolean changed = false;
        for (int i = 1; i < n-1; i++) {
            int l = nums[i-1];
            int m = nums[i];
            int r = nums[i+1];
            if(l <= m && m <= r) {
                continue;
            }
            if(l > m && m > r) {
                return false;
            }
            if(changed) {
                return false;
            }
            if(l > m) {
                if(l <= r) {
                    nums[i] = r;
                }else {
                    nums[i-1] = m;
                }
            }
            if(m > r) {
                if(l <= r) {
                    nums[i] = r;
                }else {
                    nums[i+1] = m;
                }
            }
            changed = true;
        }
        return true;
    }
}
