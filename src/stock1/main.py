# Say you have an array for which the ith element is the price of a given
# stock on day i.

# If you were only permitted to buy one share of the stock and sell one
# share of the stock, design an algorithm to find the best times to buy
# and sell.
'''
Created on May 13, 2013
@author: Yubin Bai
'''

class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
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
    data = [1, 22, 13, 55]
    s = Solution()
    print(s.maxProfit(data))
