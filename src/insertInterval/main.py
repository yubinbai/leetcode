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

    def overlap(self, other):
        return self.end >= other.start

    def merge(self, other):
        return Interval(min(self.start, other.start), max(self.end, other.end))


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
        currI = intervals[0]
        for i in range(1, len(intervals)):
            nextI = intervals[i]
            if currI.overlap(nextI):
                currI = currI.merge(nextI)
            else:
                result.append(currI)
                currI = nextI
        result.append(currI)
        return result


if __name__ == '__main__':
    intervals = [[1, 3], [6, 9]]
    intervals = [Interval(i[0], i[1]) for i in intervals]
    s = Solution()
    for i in s.insert(intervals, Interval(2, 5)):
        print i.start, ' ', i.end

    print "******"
    intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    intervals = [Interval(i[0], i[1]) for i in intervals]
    s = Solution()
    for i in s.insert(intervals, Interval(4, 9)):
        print i.start, ' ', i.end
