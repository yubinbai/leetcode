public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (s.length() > t.length()) {
            String swap = s;
            s = t;
            t = swap;
        }
        if (s.length() == t.length()) {
            boolean hasDiff = false;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (hasDiff) return false;
                    else hasDiff = true;
                }
            }
            return hasDiff;
        } else { // s.length() < t.length()
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
            return t.length() == s.length() + 1;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%s\n", s.isOneEditDistance("abc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "bbbc"));

        System.out.format("%s\n", s.isOneEditDistance("abc", "abd"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abcc"));
        System.out.format("%s\n", s.isOneEditDistance("abcc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("aabc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "aabc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abbc"));

        System.out.println("CATS");
        System.out.format("%s\n", s.isOneEditDistance("cat", "dog"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cats"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cut"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cast"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "at"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "acts"));
    }
}