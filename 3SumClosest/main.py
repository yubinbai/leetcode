# Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
# Find all unique triplets in the array which gives the sum of zero.

# Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
# The solution set must not contain duplicate triplets.

# Solution:
# This problem is the extension of the problem below:
# Given a set S of n integers, find all pairs of integers of a and b in S
# such that a + b = k?

# The above problem can be solved in O(n) time, assuming that the set S is already sorted. By
# using two index first and last, each pointing to the first and last element, we look at the
# element pointed by first, which we call A. We know that we need to find B = k – A, the
# complement of A. If the element pointed by last is less than B, we know that the choice is
# to increment pointer first by one step. Similarly, if the element pointed by last is greater
# than B, we decrement pointer last by one step. We are progressively refining the sum step by
# step. Since each step we move a pointer one step, there are at most n steps, which gives the
# complexity of O(n).

# By incorporating the solution above, we can solve the 3sum problem in O(n^2) time, which is
# a straight forward extension.

'''
Created on 2013-5-19

@author: Yubin Bai
'''


def threeSumClosest(array, target):
    array.sort()
    size = len(array)
    result = [1 << 33, -1, -1, -1]  # a large number
    for first in range(size - 2):
        left = first + 1
        right = size - 1
        while left < right:
            curr = array[first] + array[left] + array[right]
            distance = abs(curr - target)
            if distance < result[0]:
                result = [distance, array[first], array[left], array[right]]
            if curr < target:
                left += 1
            else:
                right -= 1

    return result[1] + result[2] + result[3]


if __name__ == '__main__':
    data = [-1, 2, 1, -2]
    target = 1
    print(threeSumClosest(data, target))
