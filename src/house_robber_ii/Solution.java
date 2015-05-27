public class Solution {
    public int rob(int[] nums) {
        int dp0 = 0, dp1 = 0, _dp0 = 0, _dp1 = 0;
        int n = nums.length;
        if (n == 1) return nums[0];

        for (int i = 1; i < n; ++i) {
            _dp0 = Math.max(dp0, dp1);
            _dp1 = Math.max(dp0 + nums[i], dp1);
            dp0 = _dp0;
            dp1 = _dp1;
        }
        int result1 = Math.max(dp0, dp1);
        dp0 = dp1 = _dp0 = _dp1 = 0;
        for (int i = 0; i < n - 1; ++i) {
            _dp0 = Math.max(dp0, dp1);
            _dp1 = Math.max(dp0 + nums[i], dp1);
            dp0 = _dp0;
            dp1 = _dp1;
        }
        int result2 = Math.max(dp0, dp1);
        return Math.max(result1, result2);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums;

        nums = new int[] {1, 2, 3, 4};
        System.out.println(s.rob(nums));

        nums = new int[] {1, 2, 3};
        System.out.println(s.rob(nums));

        nums = new int[] {1, 20, 3};
        System.out.println(s.rob(nums));

        nums = new int[] {1, 20, 30, 30};
        System.out.println(s.rob(nums));
    }
}