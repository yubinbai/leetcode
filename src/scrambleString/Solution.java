public class Solution {
    String s1, s2;
    int n;
    byte[][][] memo;
    static byte VALID = 2, FAILED = 1, UNSEEN = 0;
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.n = s1.length();
        memo = new byte[n + 1][n + 1][n + 1];
        return isScramble(n, 0, 0) == VALID;
    }
    private byte isScramble(int len, int i1, int i2) {
        if (memo[len][i1][i2] != UNSEEN) return memo[len][i1][i2];
        String str1 = s1.substring(i1, i1 + len);
        String str2 = s2.substring(i2, i2 + len);
        if (str1.equals(str2)) {
            return memo[len][i1][i2] = VALID;
        }
        for (int i = 1; i < len; ++i) {
            if (isScramble(i, i1, i2) == VALID
                    && isScramble(len - i, i1 + i, i2 + i) == VALID
               ) {
                return memo[len][i1][i2] = VALID;
            }
            if (isScramble(i, i1, i2 + (len - i)) == VALID
                    && isScramble(len - i, i1 + i, i2) == VALID
               ) {
                return memo[len][i1][i2] = VALID;
            }
        }
        return memo[len][i1][i2] = FAILED;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isScramble("abc", "abc"));
        System.out.println(s.isScramble("abc", "cra"));
        System.out.println(s.isScramble("abc", "cba"));
        System.out.println(s.isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }
}