public class Solution {
    public boolean isMatch(String s, String p) {

        if (p.length() == 0) return s.length() == 0;

        //p's length 1 is special case
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))) return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
            // case of a*
            int i = -1;
            while (i < s.length() && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
                if (isMatch(s.substring(i + 1), p.substring(2))) return true;
                i++;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b;
        b = s.isMatch("aa", "a"); System.out.println(b);
        b = s.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a*"); System.out.println(b);
        b = s.isMatch("aab", ".*a*b"); System.out.println(b);
        b = s.isMatch("aab", ".*"); System.out.println(b);
        b = s.isMatch("ab", ".*c"); System.out.println(b);
        b = s.isMatch("a", "ab*"); System.out.println(b);
    }
}