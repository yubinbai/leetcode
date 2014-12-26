import java.util.*;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (den == 0) return "";
        if (num == 0) return "0";
        long sign = num / Math.abs(num) * (den / Math.abs(den));
        num = Math.abs(num);
        den = Math.abs(den);

        long g = gcd(num, den);
        num /= g;
        den /= g;
        StringBuilder sb = new StringBuilder();
        sb.append(num / den);
        num = num % den;
        if (num != 0) {
            sb.append('.');
            ArrayList<Long> digits = new ArrayList<Long>();
            ArrayList<Long> nums = new ArrayList<Long>();
            while (true) {
                num *= 10;
                long digit = num / den;
                num %= den;
                if (num == 0) {
                    digits.add(digit);
                    for (long i : digits) {
                        sb.append(i);
                    }
                    break;
                } else {
                    int pos = -1;
                    for (int i = 0; i < digits.size(); ++i) {
                        if (digits.get(i) == digit && num == nums.get(i)) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos != -1) {
                        for (int i = 0; i < pos; ++i) {
                            sb.append(digits.get(i));
                        }
                        sb.append("(");
                        for (int i = pos; i < digits.size(); ++i) {
                            sb.append(digits.get(i));
                        }
                        sb.append(")");
                        break;
                    } else {
                        digits.add(digit);
                        nums.add(num);
                    }
                }
            }
        }
        if (sign == -1) sb.insert(0, '-');
        return sb.toString();
    }
    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%s\n", s.fractionToDecimal(-1, -2147483648));
        System.out.format("%s\n", s.fractionToDecimal(21, 2));
        System.out.format("%s\n", s.fractionToDecimal(-50, 8));
        System.out.format("%s\n", s.fractionToDecimal(1, 99));
        System.out.format("%s\n", s.fractionToDecimal(257, 256));
        System.out.format("%s\n", s.fractionToDecimal(1, 3));
        System.out.format("%s\n", s.fractionToDecimal(2, 3));
        System.out.format("%s\n", s.fractionToDecimal(3, 3));
        System.out.format("%s\n", s.fractionToDecimal(1, 11));
    }
}