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
            for (int j : new int[] {0, m - 1}) {
                if (!seen[i][j] && b[i][j] == 'O') {
                    bfs(i, j);
                }
            }
        }
        for (int j = 0; j < m; ++j) {
            for (int i : new int[] {0, n - 1}) {
                if (!seen[i][j] && b[i][j] == 'O') {
                    bfs(i, j);
                }
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
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        boolean isContained = true;
        int[][] direction = new int[][] {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};
        q.offerLast(r * m + c);
        b[r][c] = 'A';
        while (!q.isEmpty()) {
            int curr = q.pollFirst();
            int rr = curr / m, cc = curr % m;
            seen[rr][cc] = true;
            for (int[] d : direction) {
                int r2 = d[0] + rr;
                int c2 = d[1] + cc;
                if (r2 >= n || r2 < 0 || c2 >= m || c2 < 0) {
                    continue;
                } else if (!seen[r2][c2] && b[r2][c2] == 'O') {
                    q.offerLast(r2 * m + c2);
                    b[r2][c2] = 'A';
                }
            }
        }
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] board;

        // board = new String[] {"XXXX", "XOOX", "XXOX", "XOXX"};
        // String[] board = new String[] {"OXOOOOOOO", "OOOXOOOOX", "OXOXOOOOX", "OOOOXOOOO", "XOOOOOOOX", "XXOOXOXOX", "OOOXOOOOO", "OOOXOOOOO", "OOOOOXXOO"};
        board = new String[] {"OOOOOOOOXOOOOOXOOOOO", "OOOOOOOXOOOOOOOOOOOO", "XOOXOXOOOOXOOXOOOOOO", "OOOOOOOOOOOOOOOOOXXO", "OXXOOOOOOXOOOOOOOOOO", "OOOOXOOOOOOXOOOOOXXO", "OOOOOOOXOOOOOOOOOOOO", "OOOOOOOOOOOOOXOOOOOO", "OOOOOOOOOOOOOOOOOOXO", "OOOOOXOOOOOOOOOOOOOO", "OOOOOOOOXOOOOOOOOOOO", "OOOOXOOOOXOOOOOOOOOO", "OOOOOOOOXOOOOOOOOOOO", "XOOOOOOOOXXOOOOOOOOO", "OOOOOOOOOOOXOOOOOOOO", "OOOOXOOOOOOOOXOOOOOX", "OOOOOXOOOOOOOOOXOXOO", "OXOOOOOOOOOOOOOOOOOO", "OOOOOOOOXXOOOXOOXOOX", "OOOOOOOOOOOOOOOOOOOO"};

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