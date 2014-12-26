public class Solution {
    public int maxProduct(int[] A) {
        int n = A.length;
        int ret = A[0];
        int runningMax = 1;
        int runningMin = 1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0) {
                ret = Math.max(ret, 0);
                runningMax = runningMin = 1;
            } else {
                int rMax = (runningMax < 0) ? A[i] : runningMax * A[i];
                int rMin = runningMin * A[i];
                runningMax = Math.max(rMax, rMin);
                runningMin = Math.min(rMax, rMin);
                ret = Math.max(ret, runningMax);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.maxProduct(new int[] {2, 3, 2, -1, -2, 4}));
        System.out.format("%d\n", s.maxProduct(new int[] {0, 2}));
        System.out.format("%d\n", s.maxProduct(new int[] { -1, 0, -2}));
        System.out.format("%d\n", s.maxProduct(new int[] {3, -1, 4}));
    }
}