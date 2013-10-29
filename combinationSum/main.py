# Given a set of candidate numbers (C) and a target number (T), find all
# unique combinations in C where the candidate numbers sums to T.

# The same repeated number may be chosen from C unlimited number of times.

# Note:
# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
# The solution set must not contain duplicate combinations.
# For example, given candidate set 2,3,6,7 and target 7,
# A solution set is:
# [7]
# [2, 2, 3]

'''
Created on May 16, 2013

@author: Yubin Bai
'''


def combinationSum(array, target):
    '''
    find the way to get to sum target using
    combination of array elements
    data can be used multiple times
    '''
    def _combinationSum(target, step):
        if target == 0:
            results.append(list(stack))
            return
        if target < 0 or step == len(array):
            return

        # use the current value
        stack.append(array[step])
        _combinationSum(target - array[step], step)
        stack.pop()

        # do not use the current value
        _combinationSum(target, step + 1)

    results = []
    stack = []
    _combinationSum(target, 0)
    return results

if __name__ == '__main__':
    data = [2, 3, 6, 7]
    target = 10
    results = combinationSum(data, target)
    for i in results:
        print(i)
