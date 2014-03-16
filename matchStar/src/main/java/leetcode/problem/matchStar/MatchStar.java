package leetcode.problem.matchStar;

/**
 * Implement regular expression matching with support for ‘.’ and ‘*’.
 *
 * ‘.’ Matches any single character.
 *
 * ‘*’ Matches zero or more of the preceding element. The matching should cover
 * the entire input string (not partial).
 *
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 *
 * Some examples: isMatch(“aa”,”a”) → false isMatch(“aa”,”aa”) → true
 * isMatch(“aaa”,”aa”) → false isMatch(“aa”, “a*”) → true isMatch(“aa”, “.*”) →
 * true isMatch(“ab”, “.*”) → true isMatch(“aab”, “c*a*b”) → true
 *
 * Solution : If the next character of p is NOT ‘*’, then it must match the
 * current character of s. Continue pattern matching with the next character of
 * both s and p. If the next character of p is ‘*’, then we do a brute force
 * exhaustive matching of 0, 1, or more repeats of current character of p… Until
 * we could not match any more characters.
 *
 */
public class MatchStar {

    public static boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private static boolean isMatch(char[] s, char[] p, int sPos, int pPos) {

        if (pPos > p.length || sPos > s.length)
            return false;
        if (pPos == p.length)
            return (sPos == s.length);

        // next char is not '*': must match current character
        if (pPos + 1 == p.length || p[pPos + 1] != '*') {

            return ((p[pPos] == s[sPos]) || (p[pPos] == '.' && sPos != s.length))
                   && isMatch(s, p, sPos + 1, pPos + 1);
        } else {
            // next char is '*'
            while (sPos < s.length
                    && (p[pPos] == s[sPos] || (sPos < s.length && p[pPos] == '.'))) {
                if (isMatch(s, p, sPos, pPos + 2))
                    return true;
                sPos++;
            }
            return isMatch(s, p, sPos, pPos + 2);
        }
    }
}
