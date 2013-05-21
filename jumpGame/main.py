'''
Created on May 17, 2013

@author: Administrator
'''
def jumpGame(array):
    result = [False]
    memo = {}
    return _jumpGame(array, 0, memo, result)

def _jumpGame(array, currPos, memo, result):
    if currPos in memo:
        return memo[currPos]
    if currPos == len(array) - 1:
        memo[currPos] = True
        return True
    for i in range(1, array[currPos] + 1):
        if _jumpGame(array, currPos + i, memo, result):
            memo[currPos] = True
            return True
    memo[currPos] = False
    return False

if __name__ == '__main__':
    data = [2, 3, 1, 1, 4]
    print(jumpGame(data))
    
    data = [3, 2, 1, 0, 4]
    print(jumpGame(data))
