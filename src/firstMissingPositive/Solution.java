public class Solution {
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            int target = A[i];
            while (target > 0 && target <= n && A[target - 1] != target) {
                int swap = A[target - 1];
                A[target - 1] = target;
                target = swap;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] data = new int[] { -1, 4, 2, 1, 0, -1, -1, 3};
        System.out.format("%d\n", s.firstMissingPositive(data));
    }
}