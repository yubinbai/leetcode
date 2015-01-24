public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ret = Integer.MIN_VALUE;
        while (left < right) {
            int curr = (right - left) * Math.min(height[left], height[right]);
            ret = Math.max(ret, curr);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxArea(new int[] {2, 4, 1, 3});
    }
}