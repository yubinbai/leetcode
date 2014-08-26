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
                results.append(list(stack))
                return
            if target < 0 or step == len(candidates):
                return

            # use the current value
            stack.append(candidates[step])
            _combinationSum(target - candidates[step], step)
            stack.pop()

            # do not use the current value
            _combinationSum(target, step + 1)

        candidates = sorted(candidates)
        results = []
        stack = []
        _combinationSum(target, 0)
        return results

if __name__ == '__main__':
    s = Solution()
    data = [2, 3, 6, 7]
    data = [1, 2]
    target = 3
    results = s.combinationSum(data, target)
    print results
