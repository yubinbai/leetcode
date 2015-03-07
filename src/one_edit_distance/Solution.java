public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() == t.length()) {
            int diffCount = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                }
            }
            return diffCount == 1;
        } else {
            if (s.length() > t.length()) {
                String swap = s;
                s = t;
                t = swap;
            }
            boolean shifted = false;
            int i = 0, j = 0;
            while (i < s.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (j > i) {
                        return false;
                    } else {
                        j++;
                    }
                } else {
                    i++;
                    j++;
                }
            }
            return j == t.length() || j == i + 1;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%s\n", s.isOneEditDistance("abc", "abd"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abcc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "aabc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abbc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "bbbc"));
    }
}