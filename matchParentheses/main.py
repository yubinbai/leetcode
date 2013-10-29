# Valid Parentheses Total Accepted: 1638 Total Submissions: 5867 My Submissions
# Given a string containing just the characters '(', ')', '{', '}', '['
# and ']', determine if the input string is valid.

# The brackets must close in the correct order, "()" and "()[]{}" are all
# valid but "(]" and "([)]" are not.

'''
Created on May 15, 2013
@author: Yubin Bai
'''


def isValid(array):
    stack = []
    for i in array:
        if i in ['(', '{', '[']:
            stack.append(i)
        if i in [')', '}', ']']:
            if stack and _match(stack[-1], i):
                stack.pop()
            else:
                return False
    return len(stack) == 0


def _match(c1, c2):
    return any([c1 == '(' and c2 == ')', c1 == '[' and c2 == ']', c1 == '{' and c2 == '}'])

if __name__ == '__main__':
    print(isValid('()[]{}{}{}{}'))
    print(isValid('(]'))
    print(isValid('([)]'))
