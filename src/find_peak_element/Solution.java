public class Solution {
    public int findPeakElement(int[] num) {
        int n = num.length;
        int low = 0;
        int high = n - 1;
        int mid = 0, v1, v2;
        while ( low < high ) {
            mid = low + (high - low) / 2;
            // Compare middle element with its neighbours (if neighbours exist)
            if (( mid == 0 || num[mid] > num[mid - 1] )
                    &&
                    ( mid == n - 1 || num[mid] > num[mid + 1] )) {
                return mid;
            }
            // If middle element is not peak and its left neighbor is greater than it
            // then left half must have a peak element
            if (mid > 0 && num[mid - 1] > num[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0, 1, 2, 9, 7, 5, 4, 2, 1};
        System.out.format("%d\n", s.findPeakElement(arr));
    }
}
