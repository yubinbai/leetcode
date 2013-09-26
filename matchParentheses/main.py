'''
Created on May 15, 2013

@author: Yubin Bai
'''


def matched(array):
    stack = []
    for i in array:
        if i in ['(', '{', '[']:
            stack.append(i)
        if i in [')', '}', ']']:
            if len(stack) > 0 and _match(stack[-1], i):
                stack.pop()
            else:
                return False
    if len(stack) == 0:
        return True
    return False


def _match(c1, c2):
    return any([c1 == '(' and c2 == ')', c1 == '[' and c2 == ']', c1 == '{' and c2 == '}'])

if __name__ == '__main__':
    print(matched('()[]{}{}{}{}'))
    print(matched('(]'))
    print(matched('([)]'))
