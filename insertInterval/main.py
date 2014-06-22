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
import operator
# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    def insert(self, intervals, newInterval):
        result = []
        # sort the intervals by start
        intervals.append(newInterval)
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
    intervals = [[1, 3], [6, 9]]
    intervals = [Interval(i[0], i[1]) for i in intervals]
    s = Solution()
    for i in s.insert(intervals, Interval(2, 5)):
        print i.start, ' ', i.end

    intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    intervals = [Interval(i[0], i[1]) for i in intervals]
    s = Solution()
    for i in s.insert(intervals, Interval(4, 9)):
        print i.start, ' ', i.end
