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
        return max(maxSum, self.maxProfit1(prices))

    # @param prices, a list of integer
    # @return an integer
    def maxProfit1(self, prices):
        if len(prices) == 0:
            return 0
        currProfit = ret = 0
        currMin = prices[0]
        for j in range(1, len(prices)):
            currMin = min(currMin, prices[j])
            currProfit = prices[j] - currMin
            ret = max(currProfit, ret)
        return ret

if __name__ == '__main__':
    prices = [1, 9, 10, 4, 15, 100]
    # prices = [1, 2, 3, 4]
    s = Solution()
    print(s.maxProfit(prices))
