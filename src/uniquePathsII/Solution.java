public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        int[][] ret = new int[n][m];
        ret[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int j = 1; j < m; j++) {
            ret[0][j] = (obstacleGrid[0][j] == 0) ? ret[0][j - 1] : 0;
        }
        for (int i = 1; i < n; i++) {
            ret[i][0] = (obstacleGrid[i][0] == 0) ? ret[i - 1][0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    ret[i][j] = ret[i - 1][j] + ret[i][j - 1];
                } else {
                    ret[i][j] = 0;
                }
            }
        }
        return ret[n - 1][m - 1];
    }
    public static void main(String[] args) {
        int[][] data = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        Solution sol = new Solution();
        int result = sol.uniquePathsWithObstacles(data);
        System.out.println(result);
    }
}