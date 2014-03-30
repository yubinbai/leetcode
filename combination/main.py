# Given two integers n and k, return all possible combinations of k
# numbers out of 1 ... n.

# For example,
# If n = 4 and k = 2, a solution is:

# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]

class Solution:
    # @return a list of lists of integers
    def combine(self, n, k):
        results = []
        stack = []

        def comb(curr, step):
            if step == k:
                results.append(list(stack))
                return
            for i in range(curr, n + 1):
                stack.append(i)
                comb(i + 1, step + 1)
                stack.pop()

        comb(1, 0)
        return results

s = Solution()
print s.combine(1, 0)
print s.combine(4, 2)
