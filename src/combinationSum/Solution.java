import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>>  ret;
    Stack<Integer> stack;
    int[] candidates;
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<ArrayList<Integer>>();
        stack = new Stack<Integer>();
        this.candidates = candidates;
        solve(target, 0);
        return ret;
    }
    private void solve(int target, int step) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = step; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                stack.push(candidates[i]);
                solve(target - candidates[i], i);
                stack.pop();
            }
        }
    }
    /**
     * same function without using loop
     * @param target [description]
     * @param step   [description]
     */
    private void solve2(int target, int step) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(stack));
            return;
        }
        if (step == candidates.length) {
            return;
        }
        if (candidates[step] <= target) {
            stack.push(candidates[step]);
            solve(target - candidates[step], step);
            stack.pop();
        }
        solve(target, step + 1);
    }
    public static void main(String[] args) {
        int[] a = new int[] {21, 46, 35, 20, 44, 31, 29, 23, 45, 37, 33, 34, 39, 42, 24, 40, 41, 26, 22, 38, 36, 27, 25, 49, 48, 43};
        Solution s = new Solution();
        for (ArrayList<Integer> list : s.combinationSum(a, 71)) {
            System.out.format("%s\n", list.toString());
        }
    }
}