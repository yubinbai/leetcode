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
