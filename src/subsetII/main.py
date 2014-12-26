# Given a collection of integers that might contain duplicates, S,
# return all possible subsets.
# Note:
# Elements in a subset must be in non-descending order.
# The solution set must not contain duplicate subsets.
# For example,
# If S = [1,2,2], a solution is:
# [[2], [1], [1,2,2], [2,2], [1,2], [] ]

'''
Created on May 16, 2013
@author: Yubin Bai
'''

class Solution:
    # @param num, a list of integer
    # @return a list of lists of integer
    def subsetsWithDup(self, S):
        def _subsets(step):
            results.append(list(path))
            for i in range(step, len(S)):
                if i != step and S[i] == S[i - 1]:
                    continue
                path.append(S[i])
                _subsets(i + 1)
                path.pop()
        S.sort()
        results = []
        path = []
        _subsets(0)
        return results


if __name__ == '__main__':
    S = [1, 2, 2]
    sol = Solution()
    for row in sol.subsetsWithDup(S):
        print row
