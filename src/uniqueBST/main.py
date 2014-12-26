# Given n, how many structurally unique BST's (binary search trees) that
# store values 1...n?

# For example,
# Given n = 3, there are a total of 5 unique BST's.

#    1         3     3      2      1
#     \       /     /      / \      \
#      3     2     1      1   3      2
#     /     /       \                 \
#    2     1         2                 3
'''
Created on 2013-5-19
@author: Yubin Bai
'''

class Solution:
    # @return an integer
    def numTrees(self, n):
        memo = {0: 1, 1: 1}
        def numOfUniqueBST(n):
            if n in memo:
                return memo[n]
            currSum = 0
            for i in range(n):
                currSum += numOfUniqueBST(i) * numOfUniqueBST(n - 1 - i)
            memo[n] = currSum
            return currSum
        return numOfUniqueBST(n)

if __name__ == '__main__':
    s = Solution()
    print(s.numTrees(3))
    print(s.numTrees(4))
