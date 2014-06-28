# Given a collection of numbers that might contain duplicates, return all
# possible unique permutations.

# For example,
# [1,1,2] have the following unique permutations:
# [1,1,2], [1,2,1], and [2,1,1].

'''
Created on May 16, 2013
@author: Yubin Bai
'''


class Solution:
    # @param num, a list of integer
    # @return a list of lists of integers

    def permuteUnique(self, num):
        def _uniquePermutations():
            if len(path) == len(num):
                results.append(list(path))
                return
            for i in range(len(num)):
                if used[i] or (i != 0 and num[i] == num[i - 1] and used[i - 1]):
                    continue
                used[i] = True
                path.append(num[i])
                _uniquePermutations()
                used[i] = False
                path.pop()

        results = []
        used = [False] * len(num)
        path = []
        num.sort()
        _uniquePermutations()
        return results


if __name__ == '__main__':
    num = [1, 1, 2]
    s = Solution()
    for p in s.permute(num):
        print p
