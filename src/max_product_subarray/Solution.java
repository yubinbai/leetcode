public class Solution {
    public int maxProduct(int[] A) {
        int ret = A[0];
        int runningMax = 1;
        int runningMin = 1;
        for (int a : A) {
            if (a == 0) {
                ret = Math.max(ret, 0);
                runningMax = runningMin = 1;
            } else {
                int v1 = runningMax * a;
                int v2 = runningMin * a;
                runningMax = Math.max(v1, Math.max(v2, a));
                runningMin = Math.min(v1, Math.min(v2, a));
                ret = Math.max(ret, runningMax);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.maxProduct(new int[] {2, 3, 2, -1, -2, -4}));
        System.out.format("%d\n", s.maxProduct(new int[] {0, 2}));
        System.out.format("%d\n", s.maxProduct(new int[] { -1, 0, -2}));
        System.out.format("%d\n", s.maxProduct(new int[] {3, -1, 4}));
    }
}