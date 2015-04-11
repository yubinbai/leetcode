public class Solution {
	public int rob(int[] num) {
		int m0 = 0, m1 = 0;
		for (int a : num) {
			int curr = m0 + a;
			m0 = Math.max(m0, m1);
			m1 = Math.max(curr, m0);
		}
		return Math.max(m0, m1);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] houses;

		houses = new int[] {1, 2, 3};
		System.out.println(s.rob(houses));

		houses = new int[] {1, 20, 3, 20};
		System.out.println(s.rob(houses));
	}
}