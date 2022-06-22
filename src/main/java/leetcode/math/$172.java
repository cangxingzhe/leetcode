package leetcode.math;

public class $172 {

    public static void main(String[] args) {
        System.out.println(new $172().trailingZeroes(5));
    }

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : (n/5+trailingZeroes(n/5));
    }
}
