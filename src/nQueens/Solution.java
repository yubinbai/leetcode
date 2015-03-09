import java.util.*;
public class Solution {
    ArrayList<String[]> ret;
    int[] curr;
    boolean[] col, diag, antiDiag;
    int n;
    public List<String[]> solveNQueens(int n) {
        this.n = n;
        ret = new ArrayList<String[]>();
        curr = new int[n];
        col = new boolean[n];
        diag = new boolean[n * 2];
        antiDiag = new boolean[n * 2];
        solve(0);
        return ret;
    }
    private void solve(int step) {
        if (step == n) {
            String[] r = new String[n];
            char[] ch = new char[n];
            for (int row = 0; row < n; row++) {
                for (int i = 0; i < n; i++) {
                    ch[i] = (i == curr[row]) ? 'Q' : '.';
                }
                r[row] = new String(ch);
            }
            ret.add(r);
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
        // s.solveNQueens(13);
        for (String[] sa : s.solveNQueens(5)) {
            for (String saa : sa) {
                System.out.println(saa);
            }
            System.out.println(" ");
        }
    }
}