'''
Created on May 20, 2013
@author: Yubin Bai
'''


class Solution:
    # @param s, a string
    # @return an integer

    def longestValidParentheses(self, s):
        if s == None or len(s) == 0:
            return 0
        maxLen = 0, 0, 0
        stack = []
        for right in range(len(s)):
            if stack and s[stack[-1]] == '(' and s[right] == ')':
                stack.pop()
                left = -1
                if stack:
                    left = stack[-1]
                if maxLen[0] < right - left:
                    maxLen = right - left, left + 1, right
            else:
                stack.append(right)
        return maxLen[0]


if __name__ == '__main__':
    sol = Solution()
    print(sol.longestValidParentheses(')()())'))
    print(sol.longestValidParentheses('((()'))
    print(sol.longestValidParentheses('((()()()'))
    print(sol.longestValidParentheses('((()()()))'))
