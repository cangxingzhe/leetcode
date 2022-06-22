package leetcode.dynamicprogramming;

public class $70 {

    public static void main(String[] args) {
        System.out.println(new $70().climbStairs(4));
        System.out.println(new $70().climbStairs(8));
    }

    public int climbStairs(int n) {
        if(n <= 2) {
            return n;
        }
        int cur = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            cur = pre + prePre;
            prePre = pre;
            pre = cur;
        }
        return cur;
    }
}
