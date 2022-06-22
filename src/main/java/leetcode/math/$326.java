package leetcode.math;

public class $326 {

    public static void main(String[] args) {
        System.out.println(new $326().isPowerOfThree2(45));
    }

    public boolean isPowerOfThree(int n) {
        while(n !=0 && n%3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        double ans = Math.log10(n) / Math.log10(3);
        String str = String.valueOf(ans);
        if(Double.valueOf(ans).isInfinite()) {
            return false;
        }
        if(Double.valueOf(ans).isNaN()) {
            return false;
        }
        return Long.parseLong(str.substring(str.indexOf(".")+1)) == 0;
    }
}
