import java.util.*;
public class Solution {
    HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
    ArrayList<Integer> keys = new ArrayList<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        for (int i : num) {
            if (freq.get(i) != null) {
                freq.put(i, freq.get(i) + 1);
            } else {
                freq.put(i, 1);
            }
        }
        for (int i : freq.keySet()) {
            keys.add(i);
            // System.out.format("%d %d\t", i, freq.get(i));
        }
        _combinationSum(target, 0);
        return ret;
    }
    private void _combinationSum(int target, int step) {
        if (target < 0 || (target != 0 && step == keys.size())) return;
        if (target == 0) {
            ArrayList<Integer> curr = new ArrayList<Integer>();
            for (int i : stack) {
                curr.add(i);
            }
            ret.add(curr);
            return;
        }
        int key = keys.get(step);
        for (int times = 0; times <= freq.get(key); times++) {
            for (int j = 0; j < times; j++) {
                stack.push(key);
            }
            // System.out.format("%d %d\t", times, key);
            _combinationSum(target - key * times, step + 1);
            for (int j = 0; j < times; j++) {
                stack.pop();
            }
        }
    }
    public static void main(String[] args) {
        // int[] data = {13, 23, 25, 11, 7, 26, 14, 11, 27, 27, 26, 12, 8, 20, 22, 34, 27, 17, 5, 26, 31, 11, 16, 27, 13, 20, 29, 18, 7, 14, 13, 15, 25, 25, 21, 27, 16, 22, 33, 8, 15, 25, 16, 18, 10, 25, 9, 24, 7, 32, 15, 26, 30, 19};
        int[] data = {1};
        int target = 1;
        Solution sol = new Solution();
        for (ArrayList<Integer> list : sol.combinationSum2(data, target)) {
            for (int i : list) {
                System.out.format("%d\t", i);
            }
            System.out.format("\n");
        }
    }
}
