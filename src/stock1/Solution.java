public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int currMin = prices[0];
        int ans = 0;
        for (int p : prices) {
            currMin = Math.min(currMin, p);
            ans = Math.max(ans, p - currMin);
        }
        return ans;
    }
}