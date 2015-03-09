public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = getFirst(A, target);
        ret[1] = getInsertion(A, target) - 1;
        if (ret[0] > ret[1]) ret[0] = ret[1] = -1;
        return ret;
    }
    public int getFirst(int[] A, int target) {
        int left = 0, right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public int getInsertion(int[] A, int target) {

        int left = 0;
        int right = A.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (A[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
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