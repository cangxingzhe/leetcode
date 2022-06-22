package leetcode.math;

public class $504 {

    public static void main(String[] args) {
        System.out.println(new $504().convertToBase7(100));
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
            int a = num / 7 , b = num % 7;
            ans = b + ans;
            num = a;
        }
        return isNeg ? "-" + ans : ans;
    }
}
