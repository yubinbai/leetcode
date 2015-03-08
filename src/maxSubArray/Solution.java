public class Solution {
    public int maxSubArray(int[] A) {
        int ans = Integer.MIN_VALUE, curr = 0;
        for (int a : A) {
            curr = Math.max(curr + a, a);
            ans = Math.max(ans, curr);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(s.maxSubArray(new int[] { -1}));
    }
}