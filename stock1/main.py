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
