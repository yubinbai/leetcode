public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return;
        if (k >= n) k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int swap = nums[start];
            nums[start] = nums[end];
            nums[end] = swap;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {0,1,2,3,4,5,6,7,8,9,10,11}; 
        // [5,6,7,1,2,3,4]
        s.rotate(nums, 3);
        for (int i : nums) {
            System.out.format("%d ", i);
        }
    }
}