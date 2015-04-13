public class Solution2 {
    String s, p;
    int sn, pn;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        sn = s.length();
        pn = p.length();
        return check(0, 0);
    }
    private boolean check(int si, int pi) {
        if (pi == pn) return si == sn;

        if (pi + 1 == pn || p.charAt(pi + 1) != '*') {
            if (si == sn) return false;
            if (p.charAt(pi) != '.' && s.charAt(si) != p.charAt(pi)) return false;
            return check(si + 1, pi + 1);
        } else { // case of a*
            if (check(si, pi + 2)) return true;
            for (int i = si; i < sn; i++) {
                if (p.charAt(pi) == '.' || p.charAt(pi) == s.charAt(i)) {
                    if (check(i + 1, pi + 2)) return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        boolean b;
        b = s.isMatch("aa", "a"); System.out.println(b);
        b = s.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a*"); System.out.println(b);
        b = s.isMatch("aab", ".*a*b"); System.out.println(b);
        b = s.isMatch("aab", ".*"); System.out.println(b);
        b = s.isMatch("ab", ".*c"); System.out.println(b);
        b = s.isMatch("a", "ab*"); System.out.println(b);
    }
}