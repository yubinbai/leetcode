# Say you have an array for which the ith element is the price of a given
# stock on day i.

# Design an algorithm to find the maximum profit. You may complete at most
# two transactions.

'''
Created on 2013-5-13
@author: Yubin Bai
'''


def bestTwoTransactions(data):
    size = len(data)
    if size <= 1:
        return 0
    if size == 2:
        return data[1] - data[0] if (data[0] < data[1]) else 0

    # find the best from 0 .. i
    bestLeft = [0] * size  # bestLeft[0] is empty
    currProfit = maxProfit = 0
    currMin = data[0]
    for i in range(1, size):
        currMin = min(currMin, data[i])
        currProfit = data[i] - currMin
        maxProfit = max(currProfit, maxProfit)
        bestLeft[i] = maxProfit

    # find the best from i .. n-1
    bestRight = [0] * size  # bestRight[size-1] is empty
    currProfit = maxProfit = 0
    currMax = data[size - 1]
    for i in range(size - 1, -1, -1):
        currMax = max(currMax, data[i])
        currProfit = currMax - data[i]
        maxProfit = max(currProfit, maxProfit)
        bestRight[i] = maxProfit

    # find the best pair
    maxSum = 0
    for i in range(size - 1):
        maxSum = max(maxSum, bestLeft[i] + bestRight[i + 1])
    return maxSum

if __name__ == '__main__':
    data = [1, 9, 10, 4, 15, 100]
    data = [1, 2, 3, 4]
    # data = [1, 2]
    print(data)
    print(bestTwoTransactions(data))
