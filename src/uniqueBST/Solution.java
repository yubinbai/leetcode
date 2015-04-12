public class Solution {
	public int numTrees(int n) {
		if (n <= 1) return 1;
		int[] catalan = new int[n + 2];
		catalan[0] = catalan[1] = 1;
		for (int i = 2; i <= n + 1; i++) {
			for (int j = 0; j < i; j++) {
				catalan[i] += catalan[j] * catalan[i - j];
			}
		}
		return catalan[n + 1];
	}
	public static void main(String[] args) {
		Solution s = new Solution();

		System.out.println(s.numTrees(2));
		System.out.println(s.numTrees(3));
	}
}