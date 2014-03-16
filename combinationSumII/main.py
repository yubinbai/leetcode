# Given a collection of candidate numbers (C) and a target number (T),
# find all unique combinations in C where the candidate numbers sums to T.

# Each number in C may only be used once in the combination.

# Note:
# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
# The solution set must not contain duplicate combinations.
# For example, given candidate set 10,1,2,7,6,1,5 and target 8,
# A solution set is:
# [1, 7]
# [1, 2, 5]
# [2, 6]
# [1, 1, 6]

'''
Created on May 16, 2013
@author: Yubin Bai
'''


def combinationSum(array, target):
    # each data can be used only once
    def _combinationSum(target, step):
        if target < 0 or step == len(array):
            return
        if target == 0:
            r = tuple(stack)
            if r not in results:
                results.append(r)
            return

        # use the current value
        stack.append(array[step])
        _combinationSum(target - array[step], step + 1)
        stack.pop()

        # do not use
        _combinationSum(target, step + 1)

    results = []
    stack = []
    _combinationSum(target, 0)
    for i in results:
        print(i)


if __name__ == '__main__':
    data = [10, 1, 2, 7, 6, 1, 5]
    data.sort()
    target = 8
    combinationSum(data, target)
