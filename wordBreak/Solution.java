import java.util.*;
public class Solution {
    public int[][] memo;
    public Set<String> dict;
    public String s;

    private int dp(int a, int b) {
        if (memo[a][b] != -1)
            return memo[a][b];
        if (dict.contains(s.substring(a, b + 1))) {
            return memo[a][b] = 1;
        }

        for (int i = a; i < b; i++) {
            if ( dp(a, i) > 0 && dp(i + 1, b) > 0) {
                return memo[a][b] = 1;
            }
        }
        return memo[a][b] = 0;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        this.dict = dict;
        this.s = s;
        int n = s.length();
        memo = new int[n][n];
        for (int[] arr : memo)
            Arrays.fill(arr, -1);
        return dp(0, n - 1) > 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        System.out.println(s.wordBreak("leetcode", set));
    }
}