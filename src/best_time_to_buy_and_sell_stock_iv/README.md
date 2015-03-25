Problem
====
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Solution
===

DP

1. easy to figure out only one trans
2. state: dp(# of trans, endingIndex) -> max_profit
3. base state: 
    no transactions: dp(0, x) -> 0
    end at zero: dp(x, 0) -> 0

4. states transformation:

    dp[k+1][i+1] = max(dp[k][i+1], dp[k+1][i], max( dp[k][j] + prices[i] - prices[j] ))

    = max(dp[k][i+1], dp[k+1][i], prices[i] + max( dp[k][j] - prices[j] )) { 0 <= j < i }

With critical datasets, the time limit is quite tight. Use a greedy method as in "best stocks II"