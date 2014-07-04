import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[10];
        int n = 9;
        // row
        for (int i = 0; i < n; i++) {
            Arrays.fill(used, false);
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (used[board[i][j] - '0']) {
                    return false;
                } else {
                    used[board[i][j] - '0'] = true;
                }
            }
        }
        //col
        for (int j = 0; j < n; j++) {
            Arrays.fill(used, false);
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '.') continue;
                if (used[board[i][j] - '0']) {
                    return false;
                } else {
                    used[board[i][j] - '0'] = true;
                }
            }
        }
        // box
        for (int ii = 0; ii < n; ii += 3) {
            for (int jj = 0; jj < n; jj += 3) {
                Arrays.fill(used, false);
                for (int i = ii; i < ii + 3; i++) {
                    for (int j = jj; j < jj + 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (used[board[i][j] - '0']) {
                            return false;
                        } else {
                            used[board[i][j] - '0'] = true;
                        }
                    }

                }

            }
        }
        return true;
    }
}