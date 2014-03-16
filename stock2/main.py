# Say you have an array for which the ith element is the price of a given
# stock on day i.

# unlimited buy and sell
'''
Created on May 13, 2013
@author: Yubin Bai
'''


def profits(data):
    return sum(data[i] - data[i - 1] for i in range(1, len(data))
               if data[i] > data[i - 1])

if __name__ == '__main__':
    data = [1, 2, 5, 4, 9, 2]
    print(profits(data))
