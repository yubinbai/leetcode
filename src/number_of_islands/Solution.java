import java.util.*;
public class Solution {
	int n, m;
	public int numIslands(char[][] grid) {
		int counter = 0;
		n = grid.length;
		if (n == 0) return 0;
		m = grid[0].length;
		if (m == 0) return 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1') {
					counter++;
					dfs(i, j, grid);
				}
			}
		}
		return counter;
	}
	public void dfs(int i, int j, char[][] grid) {
		if (i < 0 || i >= n || j < 0 || j >= m) return;
		if (grid[i][j] == '1') {
			grid[i][j] = 0;
			dfs(i + 1, j, grid);
			dfs(i - 1, j, grid);
			dfs(i, j + 1, grid);
			dfs(i, j - 1, grid);
		}

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