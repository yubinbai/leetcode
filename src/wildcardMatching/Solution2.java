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
        if (si == sn) {
            while (pi < pn && p.charAt(pi) == '*') {
                pi++;
            }
            return pi == pn;
        }
        if (pi == pn) return false;

        switch (p.charAt(pi)) {
        case '?':
            return check(si + 1, pi + 1);
        case '*':
            if (pi > 0 && p.charAt(pi - 1) == '*') return false;
            for (int i = si; i <= sn; i++) {
                if (check(i, pi + 1)) return true;
            }
            break;
        default:
            if (s.charAt(si) != p.charAt(pi)) {
                return false;
            } else {
                return check(si + 1, pi + 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        boolean b;
        b = s.isMatch("a", "a"); System.out.println(b);
        b = s.isMatch("babbbaabbaaaaabbababaaaabbbbbbbbbbabbaaaabbababbabaa", "**a****a**b***ab***a*bab"); System.out.println(b);
        b = s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"); System.out.println(b);
        // TLE
        // b = s.isMatch("babbabbabaaaaabaabaaaaabbabaabbbaaaabbaabbbbbaabbabaabbbbaabbbabaabbaaabbbbabbbabbababaababbaaaaaabaabababbbaaabbaaaaaabbbabbbbabaabaaaabbabbaabaababbaaaababaaaaababbbaabaababbbaaabaababbabbabaaabbbbaa", "*a*ab*b*ab*a*bb**bb**a**abb*bb*ab*a*bbbb***ba***aa**ba*b*ab*ba***aaabbbaa*ba*ba*b****baabb**b*aa*aaab*a"); System.out.println(b);

        b = s.isMatch("aab", "*a*ba"); System.out.println(b);
        b = s.isMatch("aab", "*"); System.out.println(b);
        b = s.isMatch("ab", "*c"); System.out.println(b);
        b = s.isMatch("a", "ab*"); System.out.println(b);
    }
}