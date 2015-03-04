import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ret;
    Stack<Integer> curr;
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ret = new ArrayList<ArrayList<Integer>>();
        curr = new Stack<Integer>();
        _subsets(S, 0);
        return ret;
    }
    private void _subsets(int[] S, int step) {
        ret.add(new ArrayList<Integer>(curr));
        for (int i = step; i < S.length; ++i) {
            if (i == step || (S[i - 1] != S[i])) {
                curr.push(S[i]);
                _subsets(S, i + 1);
                curr.pop();
            }
        }
    }
    public static void main(String[] args) {
        int[] S = new int[] {1, 2, 2, 3};
        Solution sol = new Solution();
        for (ArrayList<Integer> a : sol.subsets(S)) {
            System.out.println(a);
        }
    }
}