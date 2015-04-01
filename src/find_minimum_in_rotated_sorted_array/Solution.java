public class Solution {
    public int findMin(int[] num) {
        int n = num.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (num[left] < num[mid]) {
                if (num[mid] <= num[right]) {
                    // all increasing, on left half
                    right = mid - 1;
                } else {
                    // up and down, on right half
                    left = mid + 1;
                }
            } else if (num[left] > num[mid]) {
                // must be on left half
                left++;
                right = mid;
            } else {
                // duplicates
                if (left == mid) {
                    return Math.min(num[left], num[right]);
                } else {
                    left++;
                }
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
        System.out.format("%d\n", s.findMin(new int[] {3, 3, 1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3}));
        System.out.format("%d\n", s.findMin(new int[] {1, 3, 3}));
    }
}