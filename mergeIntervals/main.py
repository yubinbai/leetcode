# Given a collection of intervals, merge all overlapping intervals.

# For example,
# Given [1,3],[2,6],[8,10],[15,18],
# return [1,6],[8,10],[15,18].

'''
Created on May 17, 2013
@author: Yubin Bai
'''


def mergeIntervals(data, result):
    # sort the data by left
    data.sort()
    i1 = list(data[0])
    for i in range(1, len(data)):
        i2 = list(data[i])
        if i1[1] >= i2[0]:
            i1[1] = max(i1[1], i2[1])
        else:
            result.append(list(i1))
            i1 = list(i2)
    result.append(i1)

if __name__ == '__main__':
    data = [[2, 6], [1, 3], [15, 18], [8, 10]]
    result = []
    mergeIntervals(data, result)
    print(result)
