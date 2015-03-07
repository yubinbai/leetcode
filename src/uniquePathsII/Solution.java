public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if (n == 0) return 0;
        int m = obstacleGrid[0].length;
        int[] ret = new int[m];
        ret[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 1; i < m; ++i) {
            ret[i] = (obstacleGrid[0][i] == 0) ? ret[i - 1] : 0;
        }
        if (n == 1) return ret[m - 1];
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 1) ret[0] = 0;
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    ret[j] += ret[j - 1];
                } else {
                    ret[j] = 0;
                }
            }
        }
        return ret[m - 1];
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