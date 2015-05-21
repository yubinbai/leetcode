import java.util.*;

public class Solution {
    List<List<Integer>> adj;
    int n;
    int[] status;
    int[] parent;
    List<Integer> result;
    static int UNSEEN = 0, DISCOVERED = 1, PROCESSED = 2;
    public int[] findOrder(int n, int[][] prerequisites) {
        this.n = n;
        adj = new ArrayList<List<Integer>>();
        result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }
        status = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (status[i] == UNSEEN && !dfs(i)) return new int[] {};
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
    private boolean dfs(int start) {
        status[start] = DISCOVERED;
        for (int p : adj.get(start)) {
            if (status[p] == DISCOVERED && parent[p] != start) {
                // BACK EDGE
                return false;
            }
            if (status[p] == UNSEEN) {
                parent[p] = start;
                if (!dfs(p)) return false;
            }
        }
        result.add(start);
        status[start] = PROCESSED;
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] pre;

        pre = new int[][] {{0, 1}};
        System.out.println(s.findOrder(2, pre));

        pre = new int[][] {{1, 0}};
        System.out.println(s.findOrder(2, pre));

        pre = new int[][] {{1, 0}, {0, 1}};
        System.out.println(s.findOrder(2, pre));
    }
}