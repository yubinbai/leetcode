public class Solution {
    char[] c1, c2, c3;
    byte[][][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        c1 = s1.toCharArray();
        c2 = s2.toCharArray();
        c3 = s3.toCharArray();
        dp = new byte[c1.length + 1][c2.length + 1][c3.length + 1];
        if (c1.length + c2.length != c3.length) return false;

        return isInterleaveDP(0, 0, 0) == 1;
        // return isInterleaveHelper(0, 0, 0);
    }

    public byte isInterleaveDP(int i, int j, int k) {
        if (dp[i][j][k] != 0) {
            return dp[i][j][k];
        }

        if (k == c3.length && i + j == k) {
            return dp[i][j][k] = 1;
        }

        if (i < c1.length && j < c2.length && c1[i] == c2[j] && c2[j] == c3[k]) {
            if (isInterleaveDP(i + 1, j, k + 1) == 1 || isInterleaveDP(i, j + 1, k + 1) == 1) {
                return dp[i][j][k] = 1;
            } else {
                return dp[i][j][k] = -1;
            }
        }

        if (i < c1.length && c1[i] == c3[k]) {
            return dp[i][j][k] = isInterleaveDP(i + 1, j, k + 1);
        }
        if (j < c2.length && c2[j] == c3[k]) {
            return dp[i][j][k] = isInterleaveDP(i, j + 1, k + 1);
        } else {
            return dp[i][j][k] = -1;
        }

    }

    // recursive, TLE
    public boolean isInterleaveHelper(int i, int j, int k) {
        // System.out.format("%d %d %d\n", i, j, k);

        if (k == c3.length && i + j == k) return true;

        if (i < c1.length && j < c2.length && c1[i] == c2[j] && c2[j] == c3[k]) {
            return isInterleaveHelper(i + 1, j, k + 1) || isInterleaveHelper(i, j + 1, k + 1);
        }

        if (i < c1.length && c1[i] == c3[k]) {
            return isInterleaveHelper(i + 1, j, k + 1);
        }
        if (j < c2.length && c2[j] == c3[k]) {
            return isInterleaveHelper(i, j + 1, k + 1);
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        // boolean b = s.isInterleave("aabcc", "dbbca", "aadbbcbcac");
        // boolean b = s.isInterleave("aabcc", "dbbca", "aadbbbaccc");
        boolean b = s.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa"
                                   , "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab"
                                   , "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
                                  );
        // boolean b = s.isInterleave("a", "b", "a");
        System.out.println(b);

    }
}