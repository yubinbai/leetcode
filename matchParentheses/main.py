# Valid Parentheses
# Given a string containing just the characters '(', ')', '{', '}', '['
# and ']', determine if the input string is valid.

# The brackets must close in the correct order, "()" and "()[]{}" are all
# valid but "(]" and "([)]" are not.

'''
Created on May 15, 2013
@author: Yubin Bai
'''

class Solution:
    # @return a boolean
    def isValid(self, s):
        stack = []
        for i in s:
            if i in ['(', '{', '[']:
                stack.append(i)
            if i in [')', '}', ']']:
                if stack and self._match(stack[-1], i):
                    stack.pop()
                else:
                    return False
        return len(stack) == 0


    def _match(self, c1, c2):
        return any([c1 == '(' and c2 == ')', c1 == '[' and c2 == ']', c1 == '{' and c2 == '}'])

if __name__ == '__main__':
    s = Solution()
    print(s.isValid('()[]{}{}{}{}'))
    print(s.isValid('(]'))
    print(s.isValid('([)]'))
