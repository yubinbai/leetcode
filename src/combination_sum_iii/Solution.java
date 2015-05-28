import java.util.*;

public class Solution {
    List<List<Integer>> result;
    boolean[] used;
    Stack<Integer> stack;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<List<Integer>>();
        stack = new Stack<Integer>();
        used = new boolean[10];
        search(1, k, n);        
        return result;
    }
    private void search(int start, int step, int sum) {
        if (step == 0) {
            if (sum == 0) result.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = start; i < 10; ++i) {
            if (!used[i] && sum >= i) {
                stack.add(i);
                used[i] = true;
                search(i + 1, step - 1, sum - i);
                stack.pop();
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.combinationSum3(3, 7));

        System.out.println(s.combinationSum3(3, 9));
    }
}