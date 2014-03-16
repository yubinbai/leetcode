# Say you have an array for which the ith element is the price of a given
# stock on day i.

# If you were only permitted to buy one share of the stock and sell one
# share of the stock, design an algorithm to find the best times to buy
# and sell.
'''
Created on May 13, 2013
@author: Yubin Bai
'''


def profit(data):
    currProfit = maxProfit = 0
    currMin = data[0]
    for j in range(1, len(data)):
        currMin = min(currMin, data[j])
        currProfit = data[j] - currMin
        maxProfit = max(currProfit, maxProfit)
    return maxProfit

if __name__ == '__main__':
    data = [1, 22, 13, 55]
    print(profit(data))
