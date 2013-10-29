# Given a set of non-overlapping intervals, insert a new interval into the
# intervals (merge if necessary).

# You may assume that the intervals were initially sorted according to
# their start times.

# Example 1:
# Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

# Example 2:
# Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as
# [1,2],[3,10],[12,16].

# This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

'''
Created on May 17, 2013
@author: Yubin Bai
'''


def mergeIntervals(data, result):
    # sort the data by left
    data = sorted(data)
    print(data)
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
    data = [[1, 3], [6, 9]]
    data.append([2, 5])
    result = []
    mergeIntervals(data, result)
    print(result)

    data = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    data.append([4, 9])
    result = []
    mergeIntervals(data, result)
    print(result)
