public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) return -1;
        if (n < 5) return 0;
        int ret = 0;
        while (n > 0) {
            n /= 5;
            ret += n;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.trailingZeroes(5));
        System.out.format("%d\n", s.trailingZeroes(10));
        System.out.format("%d\n", s.trailingZeroes(25));
    }
}