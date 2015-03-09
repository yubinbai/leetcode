import java.util.*;
public class Solution {
    ArrayList<String> ret;
    char[] arr;
    int n;
    public List<String> generateParenthesis(int n) {
        ret = new ArrayList<String>();
        this.n = n;
        arr = new char[2 * n];
        solve(0, 0);
        return ret;
    }
    private void solve(int left, int right) {
        if (right == n) {
            ret.add(new String(arr));
        }
        if (right < left) {
            arr[left + right] = ')';
            solve(left, right + 1);
        }
        if (left < n) {
            arr[left + right] = '(';
            solve(left + 1, right);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        for (String str : s.generateParenthesis(3)) {
            System.out.println(str);
        }
    }
}