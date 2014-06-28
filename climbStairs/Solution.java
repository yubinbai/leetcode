public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int a = 1, b = 1, t;
        for (int i = 0; i < n; i++) {
            t = b;
            b = a + b;
            a = t;
        }
        return a;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        for (int i = 2; i < 10; i++) {
            int r = s.climbStairs(i);
            System.out.format("%d\t%d\n",i, r);
        }
    }
}