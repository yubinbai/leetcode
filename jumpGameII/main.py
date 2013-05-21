'''
Created on May 17, 2013

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
'''
def jumpGame(array):
    memo = {}
    for i in range(len(array) - 1):
        memo[i] = len(array)  # a large number
    memo[len(array) - 1] = 0
    return _jumpGame(array, 0, memo)

def _jumpGame(array, currPos, memo):
    size = len(array)
    if currPos not in memo:
        return size
    if memo[currPos] != size:
        return memo[currPos]
    
    currMin = size
    for i in range(1, array[currPos] + 1):
        currMin = min(currMin, _jumpGame(array, currPos + i, memo))
    if currMin != size:
        memo[currPos] = currMin + 1    
    return memo[currPos]

if __name__ == '__main__':
    data = [2, 3, 4, 1, 4, 5]
    print(jumpGame(data))
    
    data = [3, 2, 1, 0, 4, 6]
    print(jumpGame(data))
