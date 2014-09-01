'''
Created on May 17, 2013
@author: Yubin Bai
'''
import operator
# Definition for an interval.


class Interval:

    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e


class Solution:
    # @param intervals, a list of Interval
    # @return a list of Interval

    def merge(self, intervals):
        result = []
        # sort the intervals by start
        intervals = sorted(intervals, key=operator.attrgetter('start'))
        if len(intervals) == 0:
            return intervals
        i1 = Interval(intervals[0].start, intervals[0].end)
        for i in range(1, len(intervals)):
            i2 = Interval(intervals[i].start, intervals[i].end)
            if i1.end >= i2.start:
                i1.end = max(i1.end, i2.end)
            else:
                result.append(Interval(i1.start, i1.end))
                i1 = i2
        result.append(i1)
        return result

if __name__ == '__main__':
    intervals = [[2, 6], [1, 3], [15, 18], [8, 10]]
    intervals = [Interval(i[0], i[1]) for i in intervals]
    s = Solution()
    for i in s.merge(intervals):
        print i.start, ' ', i.end
