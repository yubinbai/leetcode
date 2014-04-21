# Given n pairs of parentheses, write a function to generate all
# combinations of well-formed parentheses.

# For example, given n = 3, a solution set is:

# "((()))", "(()())", "(())()", "()(())", "()()()"

'''
Created on 2013-5-19
@author: Yubin Bai
'''

class Solution:
    # @param an integer
    # @return a list of string
    def generateParenthesis(self, n):
        def _generateParentheses(left, right):
            if left + right == n * 2:
                result.append(''.join(path))
            if left < n:
                path.append('(')
                _generateParentheses(left + 1, right)
                path.pop()
            if left > right:
                path.append(')')
                _generateParentheses(left, right + 1)
                path.pop()
        path = []
        result = []
        _generateParentheses(0, 0)
        return result


if __name__ == '__main__':
    s = Solution()
    result = s.generateParenthesis(3)
    for i in result:
        print(i)
