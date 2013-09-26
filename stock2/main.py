'''
Created on May 13, 2013

@author: Yubin Bai
'''


def profits(data):
    sumProfit = 0
    for j in range(1, len(data)):
        if data[j] > data[j - 1]:
            sumProfit += data[j] - data[j - 1]
    return sumProfit


if __name__ == '__main__':
    data = [1, 2, 5]
    print(profits(data))
