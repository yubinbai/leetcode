public class Solution {
    public int uniquePaths(int m, int n) {
        int mm = m, nn = n;
        m = Math.min(mm, nn);
        n = Math.max(mm, nn);
        int[] curr = new int[m];
        for (int j = 0; j < m; j++) {
            curr[j] = 1;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < m; j++) {
                curr[j] += curr[j - 1];
            }
        }
        return curr[m - 1];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int r = s.uniquePaths(3, 7);
        System.out.println(r);
    }
}