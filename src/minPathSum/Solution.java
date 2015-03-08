import java.util.*;
public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        for (int c = 1; c < m; c++) {
            grid[0][c] += grid[0][c - 1];
        }
        for (int r = 1; r < n; r++) {
            grid[r][0] += grid[r - 1][0];
        }

        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                grid[r][c] += Math.min(grid[r][c - 1], grid[r - 1][c]);
            }
        }
        return grid[n - 1][m - 1];

    }
    public static void main(String[] args) {
        int[][] data = {{1, 2, 5}, {3, 2, 1}};
        Solution s = new Solution();
        int result = s.minPathSum(data);
        System.out.println(result);
    }
}