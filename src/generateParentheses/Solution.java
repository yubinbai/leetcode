import java.util.*;
public class Solution {
    ArrayList<String> ret = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        solve(0, 0);
        return ret;
    }
    private void solve(int left, int right) {
        if (right == n) {
            ret.add(sb.toString());
        }
        if (right < left) {
            sb.append(')');
            solve(left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left < n) {
            sb.append('(');
            solve(left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        for (String str : s.generateParenthesis(3)) {
            System.out.println(str);
        }
    }
}