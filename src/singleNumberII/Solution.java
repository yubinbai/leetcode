public class Solution {
	public int singleNumber(int[] A) {
		int one = 0, two = 0, _one = 0, _two = 0;
		for (int a : A) {
			_one = (one ^ a) & ~two;
			_two = (one & a) | (two & ~a);
			// System.out.format("%d %d\n", _one, _two);
			one = _one;
			two = _two;
		}
		return one;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A;
		A = new int[] {3, 3, 3, 2};
		System.out.println(s.singleNumber(A));
	}
}