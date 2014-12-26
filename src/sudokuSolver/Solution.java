public class Solution {
    char[][] board;
    boolean[][] usedRow = new boolean[10][10];
    boolean[][] usedCol = new boolean[10][10];
    boolean[][][] usedBox = new boolean[3][3][10];
    boolean finished = false;
    boolean[][] fixed = new boolean[10][10];
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    validate(i, j, board[i][j]);
                    fixed[i][j] = true;
                }
            }
        }
        solve(0, 0);
    }

    public void solve(int i, int j) {
        if (i == 9 && j == 0) {
            finished = true;
            return;
        }
        if (finished) return;
        if (fixed[i][j]) {
            if (j == 8) {
                solve(i + 1, 0);
            } else {
                solve(i, j + 1);
            }
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (valid(i, j, c)) {
                    board[i][j] = c;
                    validate(i, j, c);
                    if (j == 8) {
                        solve(i + 1, 0);
                    } else {
                        solve(i, j + 1);
                    }
                    if (finished) return;
                    invalidate(i, j, c);
                }
            }
        }
    }
    public boolean valid(int i, int j, char c) {
        int a = c - '0';
        if (usedRow[i][a]) return false;
        if (usedCol[j][a]) return false;
        if (usedBox[i / 3][j / 3][a]) return false;
        return true;
    }
    public void validate(int i, int j, int c) {
        int a = c - '0';
        usedRow[i][a] = usedCol[j][a] = usedBox[i / 3][j / 3][a] = true;
    }
    public void invalidate(int i, int j, int c) {
        int a = c - '0';
        usedRow[i][a] = usedCol[j][a] = usedBox[i / 3][j / 3][a] = false;
    }
    public static void main(String[] args) {
        String[] input = {
            "..9748...",
            "7........",
            ".2.1.9...",
            "..7...24.",
            ".64.1.59.",
            ".98...3..",
            "...8.3.2.",
            "........6",
            "...2759.."
        };
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = input[i].toCharArray();
        }
        Solution sol = new Solution();
        sol.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(board[i]));
        }
    }

}




