import java.util.*;
public class Solution {
    ArrayList<String> solutions;
    String target;
    Set<String> dict;
    int n;
    boolean[] possible;
    Stack<Integer> stack;

    private void getAllSolution(int start) {
        if (start == n) {
            StringBuilder sb = new StringBuilder(target);
            for (int i = stack.size() - 1; i >= 0; --i) {
                sb.insert(stack.get(i), " ");
            }
            solutions.add(sb.toString().trim());
            return;
        }
        for (int i = start; i < n; ++i) {
            String piece = target.substring(start, i + 1);
            if (dict.contains(piece) && possible[i + 1]) { 
                int beforeChange = solutions.size();
                stack.push(i + 1);
                getAllSolution(i + 1);
                stack.pop();
                if (solutions.size() == beforeChange) {
                    possible[i + 1] = false;
                }
            }
        }
    }

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        this.target = s;
        this.n = s.length();
        this.dict = dict;
        this.solutions = new ArrayList<String>();
        this.possible = new boolean[n + 1];
        Arrays.fill(possible, true);
        this.stack = new Stack<Integer>();
        getAllSolution(0);
        return solutions;
    }

    public static void main(String[] args) {
        String[] dict = new String[] {"cat", "cats", "and", "sand", "dog"};
        String target = "catsanddog";
        // String[] dict = new String[] {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};
        // String target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        Set<String> set = new HashSet<String>();
        for (String s : dict)
            set.add(s);
        Solution sol = new Solution();
        // for (String s : set) System.out.println(s);
        for (String s : sol.wordBreak(target, set)) System.out.format("__%s__\n", s);
    }
}