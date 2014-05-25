import java.util.*;
public class Solution {
    public double pow(double x, int n) {
        if (x == 0.0) {
            if (n < 0) 
                return 0.0;
            else
                return 0.0;
        } else {
            if (n < 0) {
                if (n == Integer.MIN_VALUE) {
                    return 1.0/x * this.pow(1.0/x, Integer.MAX_VALUE);
                } else {
                    return this.pow(1.0/x, -1 * n);
                }
            } else if (n == 0) {
                return 1.0;
            } else {
                if (n % 2 == 0) {
                    double a = this.pow(x, n / 2);
                    return a * a;
                } else {
                    double a = this.pow(x, n / 2);
                    return x * a * a;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pow(2, 4));
    }
}