'''
Created on 2013-5-19

@author: Administrator
'''


def generateParentheses(depth, result):
    def _generateParentheses(left, right):
        if len(path) == depth * 2:
            result.append(''.join(path))
        if left < depth:
            path.append('(')
            _generateParentheses(left + 1, right)
            path.pop()
        if left > right:
            path.append(')')
            _generateParentheses(left, right + 1)
            path.pop()
    path = []
    _generateParentheses(0, 0)


if __name__ == '__main__':
    result = []
    generateParentheses(4, result)
    for i in result:
        print(i)
