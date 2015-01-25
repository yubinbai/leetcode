public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int currMax = A[0];
        for (int i = 0; i < n; ++i) {
            currMax = Math.max(currMax, A[i]);
            left[i] = currMax;
        }
        currMax = A[n - 1];
        for (int i = n - 1; i >= 0; --i) {
            currMax = Math.max(currMax, A[i]);
            right[i] = currMax;
        }
        int ret = 0;
        for (int i = 0; i < n; ++i) {
            ret += Math.min(left[i], right[i]) - A[i];
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}