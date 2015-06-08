import java.util.*;

public class Solution {
	public int maximalSquare(char[][] matrix) {
		int n = matrix.length;
		if (n == 0) return 0;
		int m = matrix[0].length;
		if (m == 0) return 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] -= '0';
			}
		}
		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = (char) (matrix[i - 1][j] + 1);
				}
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			char[] curr = matrix[i];
			int attempt = result + 1;
			int count = 0;
			for (char c : curr) {
				// before attempt is evaluted here
				// 'attempt - 1' is valid from the row abolve
				if ( c >= attempt ) {
					count++;
					if (count >= attempt) {
						result = attempt;
						break;
					}
				} else {
					count = 0;
				}
			}
		}
		return result * result;
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strs;
		char[][] mat;

		strs = new String[] {"10100", "10111", "11111", "10010"};
		mat = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			mat[i] = strs[i].toCharArray();
		}
		System.out.println(sol.maximalSquare(mat));

		strs = new String[] {"10100", "10111", "11111", "10111"};
		mat = new char[strs.length][];
		for (int i = 0; i < strs.length; i++) {
			mat[i] = strs[i].toCharArray();
		}
		System.out.println(sol.maximalSquare(mat));
	}
}