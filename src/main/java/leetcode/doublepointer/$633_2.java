package leetcode.doublepointer;

public class $633_2 {

    public static void main(String[] args) {
        System.out.println(new $633_2().judgeSquareSum(2147483600));
    }

    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (int)Math.sqrt(c);
        long sum = l*l + r*r;
        while(sum != c && l <= r) {
            if(sum > c) {
                r--;
            }
            if(sum < c) {
                l++;
            }
           sum = l*l + r*r;
        }
        return l <= r;
    }
}
