public class Solution {
	public int rob(int[] num) {
		int used = 0, unused = 0;
		for (int a : num) {
			int currUse = unused + a;
			int swapUsed = used;
			used = Math.max(swapUsed, currUse);
			unused = Math.max(swapUsed, unused);
		}
		return Math.max(used, unused);
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