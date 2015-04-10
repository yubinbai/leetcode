import java.util.*;
public class Solution2 {
    class Node {
        int step, target;
        Node parent;
        public Node(int s, int t, Node p) {
            step = s;
            target = t;
            parent = p;
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<Node> stack = new Stack<Node>();
        stack.add(new Node(0, target, null));
        while (!stack.isEmpty()) {
            Node e = stack.pop();
            if (e.target == 0) {
                Node curr = e;
                List<Integer> path = new ArrayList<Integer>();
                while (curr.parent != null) {
                    path.add(candidates[curr.step]);
                    curr = curr.parent;
                }
                result.add(path);
            } else {
                for (int i = e.step; i < candidates.length; i++) {
                    if (e.target >= candidates[i]) {
                        stack.add(new Node(i, e.target - candidates[i], e));
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = new int[] {21, 46, 35, 20, 44, 31, 29, 23, 45, 37, 33, 34, 39, 42, 24, 40, 41, 26, 22, 38, 36, 27, 25, 49, 48, 43};
        Solution2 s = new Solution2();
        for (List<Integer> list : s.combinationSum(a, 71)) {
            System.out.format("%s\n", list.toString());
        }
    }
}