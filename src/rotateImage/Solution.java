public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) return;
		for (int r = 0; r < (n + 1) / 2; r++) {
			for (int c = 0; c < n / 2; c++) {
				int swap = matrix[r][c];
				matrix[r][c] = matrix[n - 1 - c][r];
				matrix[n - 1 - c][r] = matrix[n - 1 - r][n - 1 - c];
				matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
				matrix[c][n - 1 - r] = swap;
			}
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1, 2},
			{3, 4}
		};
		Solution s = new Solution();
		s.rotate(matrix);
		for (int[] arr : matrix) {
			for (int i : arr) {
				System.out.format("%d ", i);
			}
			System.out.println("");
		}
	}
}