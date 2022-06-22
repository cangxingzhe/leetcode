package leetcode.math;

public class $67 {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1010", "1011"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int i = a.length() - 1, j = b.length()-1, add = 0;
            StringBuilder ans = new StringBuilder();
            while(i >= 0 || j >= 0 || add != 0) {
                int left = i >= 0 ? (a.charAt(i) - '0') : 0;
                int right = j >= 0 ? (b.charAt(j) - '0') : 0;
                int sum = left + right + add;
                ans.append(sum%2);
                add = sum/2;
                i--;
                j--;
            }
            return ans.reverse().toString();
        }
    }
}
