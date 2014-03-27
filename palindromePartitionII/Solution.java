import java.util.*;
public class Solution {
    int[][] memo;
    boolean[][] isPalindrome;
    int N;
    public int minCut(String s) {
        N = s.length();
        memo = new int[N][N];
        for (int[] arr : memo) Arrays.fill(arr, Integer.MAX_VALUE);
        isPalindrome = new boolean[N][N];

        int left, right;
        boolean flag;
        for (int center = 0; center < N; center++) {
            flag = true;
            left = center;
            right = center;
            while (left >= 0 && right < N) {
                if (s.charAt(left) != s.charAt(right)) flag = false;
                isPalindrome[left][right] = flag;
                left--;
                right++;
            }
        }
        for (int center = 0; center < N - 1; center++) {
            flag = true;
            left = center;
            right = center + 1;
            while (left >= 0 && right < N) {
                if (s.charAt(left) != s.charAt(right)) flag = false;
                isPalindrome[left][right] = flag;
                left--;
                right++;
            }
        }
        return dp(0, N - 1);
    }

    public int dp(int start, int end) {
        if (memo[start][end] != Integer.MAX_VALUE) return memo[start][end];
        if (isPalindrome[start][end]) return memo[start][end] = 0;

        int minC = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            minC = Math.min(minC, 1 + dp(start, i) + dp(i + 1, end));
        }
        return memo[start][end] = minC;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCut("aab"));
        System.out.println(s.minCut("ltsqjodzeriqdtyewsrpfscozbyrpidadvsmlylqrviuqiynbscgmhulkvdzdicgdwvquigoepiwxjlydogpxdahyfhdnljshgjeprsvgctgnfgqtnfsqizonirdtcvblehcwbzedsmrxtjsipkyxk"));
        System.out.println(s.minCut("adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece"));
    }
}