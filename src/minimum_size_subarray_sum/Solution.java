public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int total = nums[0];
        int start = 0, end = 0;
        int ret = nums.length + 1;
        while (start <= end && end < nums.length) {
            if (total < s) {
                if (end + 1 < nums.length) {
                    end++;
                    total += nums[end];
                } else {
                    break;
                }
            } else if (start <= end) {
                ret = Math.min(ret, end - start + 1);
                total -= nums[start];
                start++;
            }
        }
        return ret == nums.length + 1 ? 0 : ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        int sum;

        arr = new int[] {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        sum = 15;
        System.out.println(s.minSubArrayLen(sum, arr));

        arr = new int[] {2, 3, 1, 2, 4, 3};
        sum = 7;
        System.out.println(s.minSubArrayLen(sum, arr));

        arr = new int[] {};
        sum = 100;
        System.out.println(s.minSubArrayLen(sum, arr));

        arr = new int[] {1, 4, 4};
        sum = 4;
        System.out.println(s.minSubArrayLen(sum, arr));

        arr = new int[] {1, 2, 3, 4, 5};
        sum = 11;
        System.out.println(s.minSubArrayLen(sum, arr));
    }
}