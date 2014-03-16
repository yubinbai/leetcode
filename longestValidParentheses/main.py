'''
Given a string containing just the characters '(' and ')', find the
length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has
length = 2.

Another example is ")()())", where the longest valid parentheses
substring is "()()", which has length = 4.
'''
'''
Created on May 20, 2013
@author: Yubin Bai
'''


def longestValid(array):
    if array == None or len(array) == 0:
        return 0, 0, 0
    maxLen = 0, 0, 0
    stack = []
    for right in range(len(array)):
        if stack and array[stack[-1]] == '(' and array[right] == ')':
            stack.pop()
            left = -1
            if stack:
                left = stack[-1]
            if maxLen[0] < right - left:
                maxLen = right - left, left + 1, right
        else:
            stack.append(right)
    return maxLen


if __name__ == '__main__':
    print(longestValid(')()())'))
    print(longestValid('((()'))
    print(longestValid('((()()()'))
    print(longestValid('((()()()))'))
