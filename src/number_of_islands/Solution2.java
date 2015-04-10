import java.util.*;
public class Solution2 {
	public int numIslands(char[][] grid) {
		int counter = 0;
		int n = grid.length;
		if (n == 0) return 0;
		int m = grid[0].length;
		if (m == 0) return 0;
		int[][] direct = new int[][] {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					counter++;
					ArrayDeque<Integer> q = new ArrayDeque<Integer>();
					grid[i][j] = 0;
					q.add(i);
					q.add(j);
					while (!q.isEmpty()) {
						int r = q.poll();
						int c = q.poll();
						for (int[] d : direct) {
							int rr = d[0] + r;
							int cc = d[1] + c;
							if (rr >= 0 && rr < n && cc >= 0 && cc < m && grid[rr][cc] == '1') {
								grid[rr][cc] = 0;
								q.add(rr);
								q.add(cc);
							}
						}
					}

				}
			}
		}
		return counter;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] grid;
		String[] strs;

		strs = new String[] {"11111011111111101011", "01111111111110111110", "10111001101111111111", "11110111111111111111", "10011111111111111111", "10111111011101110111", "01111111111101101111", "11111111111101111011", "11111111110111111111", "11111111111111111111", "01111111011111111111", "11111111111111111111", "11111111111111111111", "11111011111110111111", "10111110111011110111", "11111111111101111110", "11111111111110111100", "11111111111111111111", "11111111111111111111", "11111111111111111111"};
		grid = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			grid[i] = strs[i].toCharArray();
		}
		System.out.println(s.numIslands(grid));

		strs = new String[] {"1"};
		grid = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			grid[i] = strs[i].toCharArray();
		}
		System.out.println(s.numIslands(grid));

		strs = new String[] {"11"};
		grid = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			grid[i] = strs[i].toCharArray();
		}
		System.out.println(s.numIslands(grid));
	}
}