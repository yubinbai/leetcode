import java.util.*;
public class Solution {
    public String simplifyPath(String path) {
        String[] layers = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (String curr : layers) {
            if (curr.length() == 0 || curr.equals(".")) {
                continue;
            } else if (curr.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String curr : stack) {
            sb.append("/");
            sb.append(curr);
        }
        if (sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/home/"));
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
    }
}