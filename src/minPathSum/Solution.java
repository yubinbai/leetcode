import java.util.*;
public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        if (m == 0) return 0;
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // System.out.format("%d %d\n", m, n);
        for (int layer = 1; layer < Math.max(m, n); layer++) {
            for (int j = layer; layer < n && j < m; j++) {
                grid[layer][j] += Math.min(grid[layer][j - 1], grid[layer - 1][j]);
            }
            for (int i = layer + 1; layer < m && i < n; i++) {
                grid[i][layer] += Math.min(grid[i - 1][layer], grid[i][layer - 1]);
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