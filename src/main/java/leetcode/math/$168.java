package leetcode.math;

public class $168 {

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(701));
    }

    static class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder ans = new StringBuilder();
            while(columnNumber != 0) {
                columnNumber--;
                int a = columnNumber / 26, b = columnNumber % 26;
                ans.append((char)(b + 'A'));
                columnNumber = a;
            }
            return ans.reverse().toString();
        }
    }
}
