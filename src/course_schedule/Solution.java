import java.util.*;

public class Solution {
	List<List<Integer>> adj;
	int numCourses;
	int[] status;
	int[] parent;
	static int UNSEEN = 0, DISCOVERED = 1, PROCESSED = 2;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		this.numCourses = numCourses;
		adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : prerequisites) {
			adj.get(edge[0]).add(edge[1]);
		}
		status = new int[numCourses];
		parent = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			parent[i] = -1;
		}
		for (int i = 0; i < numCourses; i++) {
			if (status[i] == UNSEEN && !dfs(i)) return false;
		}
		return true;
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
		status[start] = PROCESSED;
		return true;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] pre;

		pre = new int[][] {{0, 1}};
		System.out.println(s.canFinish(2, pre));

		pre = new int[][] {{1, 0}};
		System.out.println(s.canFinish(2, pre));

		pre = new int[][] {{1, 0}, {0, 1}};
		System.out.println(s.canFinish(2, pre));
	}
}