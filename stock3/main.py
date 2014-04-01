# Say you have an array for which the ith element is the price of a given
# stock on day i.

# Design an algorithm to find the maximum profit. You may complete at most
# two transactions.

'''
Created on 2013-5-13
@author: Yubin Bai
'''

class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        size = len(prices)
        if size <= 1:
            return 0
        if size == 2:
            if prices[0] < prices[1]:
                return prices[1] - prices[0]
            else:
                return 0
        # find the best from 0 .. i
        bestLeft = [0] * size  # bestLeft[0] is empty
        currProfit = maxProfit = 0
        currMin = prices[0]
        for i in range(1, size):
            currMin = min(currMin, prices[i])
            currProfit = prices[i] - currMin
            maxProfit = max(currProfit, maxProfit)
            bestLeft[i] = maxProfit

        # find the best from i .. n-1
        bestRight = [0] * size  # bestRight[size-1] is empty
        currProfit = maxProfit = 0
        currMax = prices[size - 1]
        for i in range(size - 1, -1, -1):
            currMax = max(currMax, prices[i])
            currProfit = currMax - prices[i]
            maxProfit = max(currProfit, maxProfit)
            bestRight[i] = maxProfit

        # find the best pair
        maxSum = 0
        for i in range(1, size - 1):
            maxSum = max(maxSum, bestLeft[i] + bestRight[i + 1])
        return maxSum

if __name__ == '__main__':
    prices = [1, 9, 10, 4, 15, 100]
    s = Solution()
    print(s.maxProfit(prices))
