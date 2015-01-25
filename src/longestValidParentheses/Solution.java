import java.util.*;
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int ret = -1;
        for (int right = 0; right < s.length(); ++right) {
            if (!stack.isEmpty() && s.charAt(stack.peek()) == '(' && s.charAt(right) == ')') {
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                ret = Math.max(ret, right - left);
            } else {
                stack.push(right);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses(")()())"));
        System.out.println(sol.longestValidParentheses("((()"));
        System.out.println(sol.longestValidParentheses("((()()()"));
        System.out.println(sol.longestValidParentheses("((()()()))"));
    }
}