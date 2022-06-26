package leetcode.greedy;

public class $122 {

    public static void main(String[] args) {
        //System.out.println(new $122().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new $122().maxProfit(new int[]{1,2,3,4,5}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n <= 1) {
            return 0;
        }
        int pre = prices[0];
        int max = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if(pre < prices[i]) {
                int temp = prices[i] - pre;
                if(max < temp) {
                    max = temp;
                    continue;
                }else {
                    pre = prices[i];
                }
            }else {
                pre = prices[i];
            }
            sum += max;
            max = 0;
        }
        return sum+max;
    }
}
