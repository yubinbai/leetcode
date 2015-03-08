public class Solution {
    public int maxProfit(int[] prices) {
        int prev = prices[0];
        int ans = 0;
        for (int p : prices) {
        	if (p > prev) ans += p - prev;
        	prev = p;
        }
        return ans;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int res = s.maxProfit(new int[] {1, 2, 15, 4, 9, 2});
    	System.out.println(res);
    }
}