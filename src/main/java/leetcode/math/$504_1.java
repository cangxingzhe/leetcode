package leetcode.math;

public class $504_1 {

    public static void main(String[] args) {
        System.out.println(new $504_1().convertToBase7(2));
        System.out.println(Integer.toBinaryString(256));
    }

    public String convertToBase7(int num) {
        if(num == 0) return "0";
        String ans = "";
        boolean isNeg = false;
        if(num < 0) {
            num = -num;
            isNeg = true;
        }
        while(num != 0) {
            int a = num / 2 , b = num % 2;
            ans = b + ans;
            num = a;
        }
        return isNeg ? "-" + ans : ans;
    }
}
