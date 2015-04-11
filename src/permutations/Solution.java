import java.util.*;
public class Solution {
    List<List<Integer>> ret;
    Stack<Integer> stack;
    boolean[] used;
    public List<List<Integer>> permute(int[] num) {
        ret = new ArrayList<List<Integer>>();
        stack = new Stack<Integer>();
        used = new boolean[num.length];
        _permute(num);
        return ret;
    }
    private void _permute(int[] n) {
        if (stack.size() == n.length) {
            ret.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < n.length; ++i) {
            if (!used[i] && (i == 0 || n[i] != n[i - 1])) {
                used[i] = true;
                stack.push(n[i]);
                _permute(n);
                used[i] = false;
                stack.pop();
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.permute(new int[] {1, 2, 3}));
    }
}