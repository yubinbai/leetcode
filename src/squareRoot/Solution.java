public class Solution {
    public int sqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;
        if (x == 1) return 1;
        double x0 = x, x1;
        while (true) {
            x1 = (x0 + 1.0 * x / x0) / 2.0;
            if (Math.abs(x0 - x1) < 1) {
                return (int) x1;
            }
            x0 = x1;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sqrt(1));
        System.out.println(s.sqrt(3));
        System.out.println(s.sqrt(9));
        System.out.println(s.sqrt(999999999));
    }
}