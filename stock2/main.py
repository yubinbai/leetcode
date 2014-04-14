# Say you have an array for which the ith element is the price of a given
# stock on day i.

# unlimited buy and sell
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
        return sum(prices[i] - prices[i - 1] for i in range(1, len(prices)) if prices[i] > prices[i - 1])

if __name__ == '__main__':
    data = [1, 2, 15, 4, 9, 2]
    s = Solution()
    print(s.maxProfit(data))
