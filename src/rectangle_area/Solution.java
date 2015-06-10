public class Solution {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int ax = Math.max(A, E);
		int ay = Math.max(B, F);
		int bx = Math.min(C, G);
		int by = Math.min(D, H);
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		int overlap = 0;
		if (ax < bx && ay < by) {
			overlap = (bx - ax) * (by - ay);
		}
		return area1 + area2 - overlap;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}
}