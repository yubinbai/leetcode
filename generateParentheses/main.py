'''
Created on 2013-5-19

@author: Administrator
'''
def generateParentheses(depth, result):
    path = []
    _generateParentheses(path, depth, 0, 0, result)

def _generateParentheses(path, depth, left, right, result):
    if len(path) == depth * 2:
        result.append(''.join(path))
    if left < depth:
        path.append('(')
        _generateParentheses(path, depth, left + 1, right, result)
        path.pop()
    if left > right:
        path.append(')')
        _generateParentheses(path, depth, left, right + 1, result)
        path.pop()
        
if __name__ == '__main__':
    result = []
    generateParentheses(4, result)
    for i in result:
        print(i)
