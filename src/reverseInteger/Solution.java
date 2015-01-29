public class Solution {
    public int reverse(int x) {
        int sign = (x < 0) ? -1 : 1;
        if (x == Integer.MIN_VALUE) {
            return 0;
        } else {
            x *= sign;
        }

        long ret = 0;
        while (x != 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        ret *= sign;
        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) ret;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(-1234567891));
    }
}