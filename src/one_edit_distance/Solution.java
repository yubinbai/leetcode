public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        int nDiff = 0;
        int i = 0, j = 0;
        for (; i < s.length() && j < t.length(); ++i, ++j) {
            if (s.charAt(i) != t.charAt(j)) {
                if (nDiff != 0) {
                    return false;
                }
                if (s.length() > t.length()) {
                    ++i;
                } else if (s.length() < t.length()) {
                    ++j;
                }
                nDiff = 1;
            }
        }
        if (nDiff == 0 && i == s.length() - 1) return true;
        if (nDiff == 0 && j == t.length() - 1) return true;
        return nDiff == 1;
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