# Given a set of candidate numbers (C) and a target number (T), find all
# unique combinations in C where the candidate numbers sums to T.

# The same repeated number may be chosen from C unlimited number of times.

# Note:
# All numbers (including target) will be positive integers.
# Elements in a combination (a1, a2,ak) must be in non-descending order.
# The solution set must not contain duplicate combinations.
# For example, given candidate set 2,3,6,7 and target 7,
# A solution set is:
# [7]
# [2, 2, 3]

'''
Created on May 16, 2013

@author: Yubin Bai
'''

class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers
    def combinationSum(self, candidates, target):

        def _combinationSum(target, step):
            if target == 0:
                results.append(sorted(stack))
                return
            if target < 0 or step == -1:
                return

            # use the current value
            stack.append(candidates[step])
            _combinationSum(target - candidates[step], step)
            stack.pop()

            # do not use the current value
            _combinationSum(target, step - 1)

        results = []
        stack = []
        _combinationSum(target, len(candidates) - 1)
        return sorted(results)

if __name__ == '__main__':
    s = Solution()
    data = [2, 3, 6, 7]
    target = 10
    results = s.combinationSum(data, target)
    print results
