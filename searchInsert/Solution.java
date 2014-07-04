public class Solution {
    public int searchInsert(int[] A, int target) {
        int left = 0, right = A.length;
        int mid;
        while (left < right) {
            mid = (left + right) >> 1;
            if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] A = {1, 3, 5, 6};
        Solution sol = new Solution();
        System.out.println(sol.searchInsert(A, 5));
        System.out.println(sol.searchInsert(A, 2));
        System.out.println(sol.searchInsert(A, 7));
        System.out.println(sol.searchInsert(A, 0));
    }
}