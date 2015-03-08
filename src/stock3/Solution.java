public class Solution {
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n <= 1) return 0;
		int[] bestLeft = new int[n + 1];
		int[] bestRight = new int[n + 1];

		int currMin = prices[0];
		for (int i = 1; i < n; i++) {
			currMin = Math.min(currMin, prices[i]);
			bestLeft[i] = Math.max(bestLeft[i - 1], prices[i] - currMin);
		}

		int currMax = prices[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			currMax = Math.max(currMax, prices[i]);
			bestRight[i] = Math.max(bestRight[i + 1], currMax - prices[i]);
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, bestLeft[i - 1] + bestRight[i]);
		}
		return ans;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices;
		prices = new int[] {};
		System.out.println(s.maxProfit(prices));
		prices = new int[] {1, 9, 10, 4, 15, 100};
		System.out.println(s.maxProfit(prices));
		prices = new int[] {1, 2, 3, 4};
		System.out.println(s.maxProfit(prices));
		prices = new int[] {1, 2};
		System.out.println(s.maxProfit(prices));
		prices = new int[] {3, 2, 6, 5, 0, 3};
		System.out.println(s.maxProfit(prices));
	}
}