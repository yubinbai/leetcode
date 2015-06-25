import java.util.*;

public class Solution {
    public int calculate(String s) {
        Stack<Long> signs = new Stack<Long>();

        long total = 0;
        long currSign = 1, prevSign = 1;
        s = "+" + s.replaceAll(" ", "");

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    long t = Long.parseLong(sb.toString());
                    total += currSign * prevSign * t;
                    sb = new StringBuilder();
                }
                switch (c) {
                    case '+':
                        prevSign = 1;
                        break;
                    case '-':
                        prevSign = -1;
                        break;
                    case '(':
                        signs.push(prevSign);
                        currSign *= prevSign;
                        prevSign = 1;
                        break;
                    case ')':
                        currSign *= signs.pop();
                        break;
                }
            }
        }
        if (sb.length() > 0) {
            long t = Long.parseLong(sb.toString());
            total += currSign * prevSign * t;
            sb = new StringBuilder();
        }
        return (int) total;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate("1-1"));
        System.out.println(s.calculate(" 2-(1 + 2) "));
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(s.calculate("1 + 1"));
        System.out.println(s.calculate(" 2-1 + 2 "));
    }
}