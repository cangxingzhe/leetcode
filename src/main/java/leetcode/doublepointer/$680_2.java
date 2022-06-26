package leetcode.doublepointer;

public class $680_2 {

    public static void main(String[] args) {
        /*System.out.println(new $680_2().validPalindrome("aba"));
        System.out.println(new $680_2().validPalindrome("abca"));
        System.out.println(new $680_2().validPalindrome("abc"));*/
        System.out.println(new $680_2().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else {
                if(right - left == 1) {
                    return true;
                }
                return valid(s, left+1, right) || valid(s, left, right-1);
            }
        }
        return true;
    }

    boolean valid(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
