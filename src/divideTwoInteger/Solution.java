public class Solution {

    public int divide(int a, int b) {
        if (b == 0) return Integer.MAX_VALUE;

        int result = 0;
        if (a == Integer.MIN_VALUE) {
            result = 1;
            a += Math.abs(b);
        }
        if (b == Integer.MIN_VALUE) return result;
        boolean isNegative = (a < 0) ^ (b < 0);
        a = Math.abs(a);
        b = Math.abs(b);
        int digit = 0;
        while (b <= (a >> 1)) {
            b <<= 1;
            digit++;
        }
        while (digit >= 0) {
            if (a >= b) {
                a -= b;
                result += 1 << digit;
            }
            b >>= 1;
            digit--;
        }
        return isNegative ? -result : result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.divide(12, 3));
    }
}