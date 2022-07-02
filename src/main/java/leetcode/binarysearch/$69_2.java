package leetcode.binarysearch;

public class $69_2 {

    public static void main(String[] args) {
        System.out.println(new $69_2().mySqrt(8));

    }

    public int mySqrt(int x) {
        if (x == 0) return x;
        int left = 1;
        int right = x;
        if(right*right == x) return x;
        while(left <= right) {
            int mid = left + (right - left)/2;
            int sqrt = x / mid;
            if(mid == sqrt) {
                return mid;
            }else if(mid > sqrt) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}
