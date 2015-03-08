public class Solution {
    char[] c1, c2, c3;
    byte[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        if (c1.length + c2.length != c3.length) return false;
        dp = new byte[c1.length + 1][c2.length + 1];
        return isInterleaveDP(0, 0) == 1;
    }

    private byte isInterleaveDP(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int k = i + j;
        if (k == c3.length) {
            return dp[i][j] = 1;
        }

        if (i < c1.length && j < c2.length && c1[i] == c2[j] && c2[j] == c3[k]) {
            if (isInterleaveDP(i + 1, j) == 1 || isInterleaveDP(i, j + 1) == 1) {
                return dp[i][j] = 1;
            } else {
                return dp[i][j] = -1;
            }
        } else if (i < c1.length && c1[i] == c3[k]) {
            return dp[i][j] = isInterleaveDP(i + 1, j);
        } else if (j < c2.length && c2[j] == c3[k]) {
            return dp[i][j] = isInterleaveDP(i, j + 1);
        } else {
            return dp[i][j] = -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean b1 = s.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        boolean b2 = s.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        boolean b3 = s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"
                                    , "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"
                                    , "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
                                   );
        boolean b4 = s.isInterleave("a", "b", "a");

        System.out.format("b1 %b\n", b1);
        System.out.format("b2 %b\n", b2);
        System.out.format("b3 %b\n", b3);
        System.out.format("b4 %b\n", b4);

    }
}