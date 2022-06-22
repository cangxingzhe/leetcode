package leetcode;

public class $680 {
    public boolean validPalindrome(String s) {
        int i=0; int j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(j - i == 1) {
                    return true;
                }

                if(s.charAt(i+1) == s.charAt(j)) {
                    i++;
                }else if(s.charAt(i) == s.charAt(j-1)) {
                    j--;
                }else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        $680 instance = new $680();
        System.out.println(instance.validPalindrome("aba"));
        System.out.println(instance.validPalindrome("abca"));
        System.out.println(instance.validPalindrome("aacbd"));
    }
}
