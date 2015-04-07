public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A;

        A = new int[] {1, 3, 5, 6};
        System.out.println(sol.searchInsert(A, 5));

        A = new int[] {1};
        System.out.println(sol.searchInsert(A, 2));

        A = new int[] {1};
        System.out.println(sol.searchInsert(A, 0));
    }
}