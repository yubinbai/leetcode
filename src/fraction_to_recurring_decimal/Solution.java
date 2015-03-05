import java.util.*;
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        if (den == 0) return "";
        if (num == 0) return "0";
        long sign = num / Math.abs(num) * (den / Math.abs(den));
        String str = fractionToDecimalPositive(Math.abs(num), Math.abs(den));
        if (sign == -1) {
            return "-" + str;
        } else {
            return str;
        }
    }
    private String fractionToDecimalPositive(long num, long den) {
        StringBuilder sb = new StringBuilder();
        sb.append(num / den);
        num = num % den;
        if (num != 0) {
            sb.append('.');
            HashMap<Long, Integer> remains = new HashMap<Long, Integer>();
            while (true) {
                num *= 10;
                long digit = num / den;
                num %= den;
                if (num == 0) {
                    sb.append(digit);
                    break;
                } else {
                    Integer pos = remains.get(num);
                    if (pos != null && sb.charAt(pos) == '0' + digit) {
                        sb.insert((int) pos, '(');
                        sb.append(")");
                        break;
                    } else {
                        sb.append(digit);
                        remains.put(num, sb.length() - 1);
                    }
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%s\n", s.fractionToDecimal(1, 6));
        System.out.format("%s\n", s.fractionToDecimal(-1, -2147483648));
        System.out.format("%s\n", s.fractionToDecimal(21, 2));
        System.out.format("%s\n", s.fractionToDecimal(-50, 8));
        System.out.format("%s\n", s.fractionToDecimal(1, 3));
        System.out.format("%s\n", s.fractionToDecimal(1, 99));
        System.out.format("%s\n", s.fractionToDecimal(257, 256));
        System.out.format("%s\n", s.fractionToDecimal(2, 3));
        System.out.format("%s\n", s.fractionToDecimal(3, 3));
        System.out.format("%s\n", s.fractionToDecimal(1, 11));
    }
}