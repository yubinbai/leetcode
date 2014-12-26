import java.util.*;
public class Solution {
    int total;
    int[] curr;
    boolean[] col, diag, antiDiag;
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        curr = new int[n];
        col = new boolean[n];
        diag = new boolean[n * 2];
        antiDiag = new boolean[n * 2];
        solve(0);
        return total;
    }
    private void solve(int step) {
        if (step == n) {
            total++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (col[i] || diag[step + i] || antiDiag[step - i + n]) continue;
            curr[step] = i;
            col[i] = diag[step + i] = antiDiag[step - i + n] = true;
            solve(step + 1);
            col[i] = diag[step + i] = antiDiag[step - i + n] = false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int sol = s.totalNQueens(13);
        System.out.println(sol);
    }
}