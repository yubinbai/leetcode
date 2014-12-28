public class Solution {
    public int findMin(int[] num) {
        int n = num.length;
        int left = 0, right = n - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (num[left] <= num[mid]) {
                if (num[mid] <= num[right]) {
                    // all increasing, on left half
                    right = mid - 1;
                } else {
                    // up and down, on right half
                    left = mid + 1;
                }
            } else {
                // must be on left half
                right = mid;
            }
        }
        return num[left];
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 6, 7, 0, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {2, 1}));
        System.out.format("%d\n", s.findMin(new int[] {3, 1, 2}));
        System.out.format("%d\n", s.findMin(new int[] {4, 5, 1, 2, 3}));
    }
}