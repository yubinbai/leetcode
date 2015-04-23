public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int count = 0;
		while (n > m) {
			n >>= 1;
			m >>= 1;
			count++;
		}
		return (m & n) << (count);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.rangeBitwiseAnd(1, 3));
		System.out.println(s.rangeBitwiseAnd(5, 7));
		System.out.println(s.rangeBitwiseAnd(3, 3));
	}
}