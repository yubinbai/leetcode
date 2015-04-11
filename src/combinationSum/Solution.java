import java.util.*;
public class Solution {
    List<List<Integer>>  ret;
    Stack<Integer> path;
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<List<Integer>>();
        path = new Stack<Integer>();
        this.candidates = candidates;
        solve(target, 0);
        return ret;
    }
    private void solve(int target, int step) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = step; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                path.push(candidates[i]);
                solve(target - candidates[i], i);
                path.pop();
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
            ret.add(new ArrayList<Integer>(path));
            return;
        }
        if (step == candidates.length) {
            return;
        }
        if (candidates[step] <= target) {
            path.push(candidates[step]);
            solve(target - candidates[step], step);
            path.pop();
        }
        solve(target, step + 1);
    }
    public static void main(String[] args) {
        int[] a = new int[] {21, 46, 35, 20, 44, 31, 29, 23, 45, 37, 33, 34, 39, 42, 24, 40, 41, 26, 22, 38, 36, 27, 25, 49, 48, 43};
        Solution s = new Solution();
        for (List<Integer> list : s.combinationSum(a, 71)) {
            System.out.format("%s\n", list.toString());
        }
    }
}