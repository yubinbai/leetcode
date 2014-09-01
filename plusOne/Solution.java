import java.util.*;
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean carry = true;
        int[] ret = Arrays.copyOf(digits, digits.length);
        int curr = digits.length - 1;
        while (curr >= 0 && carry) {
            ret[curr] += 1;
            if (ret[curr] == 10) {
                carry = true;
                ret[curr] = 0;
            } else {
                carry = false;
            }
            curr--;
        }
        if (carry) {
            int[] ret2 = new int[ret.length + 1];
            ret2[0] = 1;
            for (int i = 1; i < ret2.length; i++) {
                ret2[i] = ret[i - 1];
            }
            return ret2;
        } else {
            return ret;
        }
    }
    public static void main(String[] args) {
        int[] arg = {9, 9, 9};
        Solution sol = new Solution();
        for (int i : sol.plusOne(arg)) {
            System.out.format("%d ", i);
        }
    }
}