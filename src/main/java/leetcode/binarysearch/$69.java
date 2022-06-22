package leetcode.binarysearch;

public class $69 {
    public static void main(String[] args) {
        System.out.println(new $69().mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if (x == 0) return x;
        int l = 1;
        int r = x;
        if(r*r == x) return x;
        while(l <= r) {
            int mid = l + (r-l)/2;
            int sqrt =  x / mid;
            if(sqrt == mid) {
                return mid;
            }else if(sqrt < mid){
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return r;

    }
}
