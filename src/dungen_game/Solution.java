public class Solution {
    int[][] dungeon;
    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = left + (right - left) >> 1;
            if (valid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left % Integer.MAX_VALUE;
    }
    public boolean valid(long health) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        long[][] curr = new long[2][m + 1];

        curr[1][0] = curr[0][1] = health;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                curr[i % 2][j] = Math.max(
                                     curr[i % 2][j - 1],
                                     curr[(i - 1) % 2][j])
                                 + dungeon[i - 1][j - 1];
                if (curr[i % 2][j] < 0) curr[i % 2][j] = Long.MIN_VALUE;
            }
        }
        return curr[n % 2][m] > 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] d = new int[][] {{ -2, -3, 3}, { -5, -10, 1}, {10, 30, -5}};
        System.out.format("%d\n", s.calculateMinimumHP(d));
    }
}