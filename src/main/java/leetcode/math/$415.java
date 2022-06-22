package leetcode.math;

public class $415 {

    public static void main(String[] args) {
        System.out.println(new $415().addStrings("11", "123"));
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length()-1, j = num2.length()-1, add = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0 || add != 0) {
            int left = i >= 0 ? (num1.charAt(i) - '0') : 0;
            int right = j >= 0 ? (num2.charAt(j) - '0') : 0;
            int sum = left + right + add;
            add = sum/10;
            ans.append(sum%10);
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}
