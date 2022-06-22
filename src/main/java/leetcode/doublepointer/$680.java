package leetcode.doublepointer;

public class $680 {

    public static void main(String[] args) {
        System.out.println(new $680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        int i=0; int j = s.length() - 1;
        boolean delFlag = false;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(j - i == 1) {
                    return true;
                }
                if(delFlag) return false;
                if(s.charAt(i+1) == s.charAt(j)) {
                    i++;
                }else if(s.charAt(i) == s.charAt(j-1)) {
                    j--;
                }else {
                    return false;
                }
                delFlag = true;
            }
            i++;
            j--;
        }
        return true;
    }

}
