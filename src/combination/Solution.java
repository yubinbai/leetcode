import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    Stack<Integer> stack;
    int n;
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        this.n = n;
        ret = new ArrayList<ArrayList<Integer>>();
        stack = new Stack<Integer>();

        solve(1, k);
        return ret;
    }
    private void solve(int curr, int remain) {
        if (remain == 0) {
            ret.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = curr; i <= n; ++i) {
            stack.push(i);
            solve(i + 1, remain - 1);
            stack.pop();
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        for (ArrayList<Integer> a : s.combine(3, 2)) {
            System.out.format("%s\n", a.toString());
        }
    }
}