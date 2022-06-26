package leetcode.doublepointer;

public class $76 {

    public static void main(String[] args) {
        System.out.println(new $76().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        byte[] chars = new byte[127];
        boolean[] flags = new boolean[127];

        for (int i = 0; i < t.length(); i++) {
            flags[t.charAt(i) - 'A'] = true;
            ++chars[t.charAt(i) - 'A'];
        }

        int cnt = 0;
        int l = 0;
        int minL = 0;
        int minSize = s.length()+1;
        for (int r = 0; r < s.length(); r++) {
            int position = s.charAt(r) - 'A';
            if(flags[position]) {
                if(--chars[position] >= 0) {
                    cnt++;
                }
            }
            while(cnt == t.length()) {
                if(r - l + 1 < minSize) {
                    minL = l;
                    minSize = r - l + 1;
                }
                int pos = s.charAt(l) - 'A';
                if(flags[pos] && ++chars[pos] > 0) {
                    --cnt;
                }
                l++;
            }
        }
        return minSize > s.length() ? "" : s.substring(minL, minL + minSize);
    }

}
