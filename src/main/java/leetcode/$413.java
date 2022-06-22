package leetcode;

public class $413 {

    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        $413 instance = new $413();
        System.out.println(instance.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }
}
