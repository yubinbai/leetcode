import java.util.*;
public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		if (n == 1) return triangle.get(0).get(0);
		ArrayList<Integer> r = new ArrayList<Integer>(triangle.get(n - 2));
		ArrayList<Integer> rr = new ArrayList<Integer>(triangle.get(n - 1));
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				int small = Math.min(rr.get(j), rr.get(j + 1));
				r.set(j, r.get(j) + small);
			}
			// System.out.println(r);
			rr = r;
			if (n - i - 3 >= 0) r = new ArrayList<Integer>(triangle.get(n - i - 3));
		}
		return rr.get(0);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] t = new int[][] {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3} };
		List<List<Integer>> tList = new ArrayList<List<Integer>>();
		for (int[] arr : t) {
			ArrayList<Integer> curr = new ArrayList<Integer>();
			for (int i : arr) {
				curr.add(i);
			}
			tList.add(curr);
		}
		System.out.println(s.minimumTotal(tList));
	}
}