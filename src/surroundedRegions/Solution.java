import java.util.*;
public class Solution {
    char[][] b;
    int n, m;
    boolean[][] seen;
    public void solve(char[][] board) {
        this.b = board;
        n = board.length;
        if (n == 0) return;
        m = board[0].length;
        seen = new boolean[n][m];
        for (int i = 0; i < n; ++i) {
            int j = 0;
            if (!seen[i][j] && b[i][j] == 'O') {
                bfs(i, j);
            }
            j = m - 1;
            if (!seen[i][j] && b[i][j] == 'O') {
                bfs(i, j);
            }
        }
        for (int j = 0; j < m; ++j) {
            int i = 0;
            if (!seen[i][j] && b[i][j] == 'O') {
                bfs(i, j);
            }
            i = n - 1;
            if (!seen[i][j] && b[i][j] == 'O') {
                bfs(i, j);
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (b[i][j] == 'O') {
                    b[i][j] = 'X';
                } else if (b[i][j] == 'A') {
                    b[i][j] = 'O';
                }
            }
        }
    }
    private void bfs(int r, int c) {
        ArrayDeque<Integer> rq = new ArrayDeque<Integer>();
        ArrayDeque<Integer> cq = new ArrayDeque<Integer>();
        boolean isContained = true;
        int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
        rq.offerLast(r);
        cq.offerLast(c);
        b[r][c] = 'A';
        while (!rq.isEmpty()) {
            int rr = rq.pollFirst();
            int cc = cq.pollFirst();
            seen[rr][cc] = true;
            for (int[] d : direction) {
                int r2 = d[0] + rr;
                int c2 = d[1] + cc;
                if (r2 >= n || r2 < 0 || c2 >= m || c2 < 0) {
                    continue;
                } else if (!seen[r2][c2] && b[r2][c2] == 'O') {
                    rq.offerLast(r2);
                    cq.offerLast(c2);
                    b[r2][c2] = 'A';
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();

        // String[] board = new String[] {"XXXX", "XOOX", "XXOX", "XOXX"};
        String[] board = new String[] {"OXOOOOOOO", "OOOXOOOOX", "OXOXOOOOX", "OOOOXOOOO", "XOOOOOOOX", "XXOOXOXOX", "OOOXOOOOO", "OOOXOOOOO", "OOOOOXXOO"};
        // String[] board = new String[] {"OOOOOOOOXOOOOOXOOOOO", "OOOOOOOXOOOOOOOOOOOO", "XOOXOXOOOOXOOXOOOOOO", "OOOOOOOOOOOOOOOOOXXO", "OXXOOOOOOXOOOOOOOOOO", "OOOOXOOOOOOXOOOOOXXO", "OOOOOOOXOOOOOOOOOOOO", "OOOOOOOOOOOOOXOOOOOO", "OOOOOOOOOOOOOOOOOOXO", "OOOOOXOOOOOOOOOOOOOO", "OOOOOOOOXOOOOOOOOOOO", "OOOOXOOOOXOOOOOOOOOO", "OOOOOOOOXOOOOOOOOOOO", "XOOOOOOOOXXOOOOOOOOO", "OOOOOOOOOOOXOOOOOOOO", "OOOOXOOOOOOOOXOOOOOX", "OOOOOXOOOOOOOOOXOXOO", "OXOOOOOOOOOOOOOOOOOO", "OOOOOOOOXXOOOXOOXOOX", "OOOOOOOOOOOOOOOOOOOO"};

        char[][] board_array = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            board_array[i] = board[i].toCharArray();
        }
        sol.solve(board_array);
        for (int i = 0; i < board.length; i++) {
            System.out.format("%s\n", new String(board_array[i]));
        }
    }
}