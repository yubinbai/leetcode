import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();
        int a, b;
        for (String t : tokens) {
            switch (t) {
            case "+":
                a = s.pop();
                b = s.pop();
                s.push(a + b);
                break;
            case "-":
                a = s.pop();
                b = s.pop();
                s.push(b - a);
                break;
            case "*":
                a = s.pop();
                b = s.pop();
                s.push(a * b);
                break;
            case "/":
                a = s.pop();
                b = s.pop();
                if (a != 0) {
                    s.push(b / a);
                }
                break;
            default:
                s.push(Integer.parseInt(t));
            }
        }
        return s.pop();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.evalRPN(new String[] {"3", "-4", "+"});
    }
}