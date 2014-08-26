'''
Created on May 16, 2013
@author: Yubin Bai
'''
import collections


class Solution:
    # @param candidates, a list of integers
    # @param target, integer
    # @return a list of lists of integers

    def combinationSum2(self, candidates, target):

        # each data can be used only once
        def _combinationSum(target, step):
            if target < 0 or (target != 0 and step == len(keys)):
                return
            if target == 0:
                r = list(stack)
                results.append(r)
                return
            key = keys[step]

            # use the current value, zero or up to freq[key]
            for times in range(freq[key] + 1):
                for _ in range(times):
                    stack.append(key)
                _combinationSum(target - key * times, step + 1)
                for _ in range(times):
                    stack.pop()

        results = []
        stack = []
        freq = collections.Counter(candidates)
        keys = freq.keys()
        _combinationSum(target, 0)
        return results


if __name__ == '__main__':
    # data = [10, 1, 2, 7, 6, 1, 5]
    # data = [13, 23, 25, 11, 7, 26, 14, 11, 27, 27, 26, 12, 8, 20, 22, 34, 27, 17, 5, 26, 31, 11, 16, 27, 13, 20, 29, 18, 7, 14, 13, 15, 25, 25, 21, 27, 16, 22, 33, 8, 15, 25, 16, 18, 10, 25, 9, 24, 7, 32, 15, 26, 30, 19]
    data = [1]
    target = 1
    sol = Solution()
    for s in sol.combinationSum2(data, target):
        print s
