public class Solution {
    public int[] searchRange(int[] A, int target) {
        int left = 0, right = A.length;
        int mid;
        int[] ret = new int[2];
        while (left < right) {
            mid = (left + right) >> 1;
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        ret[0] = left;
        left = 0;
        right = A.length;
        while (left < right) {
            mid = (left + right) >> 1;
            if (A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        ret[1] = left - 1;
        if (ret[0] > ret[1]) ret[0] = ret[1] = -1;
        return ret;
    }

    public static void main(String[] args) {
        // int[] A = {5, 7, 7, 8, 8, 10};
        int[] A = {1};
        Solution sol = new Solution();
        for (int i : sol.searchRange(A, 1)) {
            System.out.format("%d\t", i);
        }
        System.out.format("\n");
        for (int i : sol.searchRange(A, 6)) {
            System.out.format("%d\t", i);
        }
    }
}