# Given an array of non-negative integers, you are initially positioned
# at the first index of the array.

# Each element in the array represents your maximum jump length at that
# position.

# Determine if you are able to reach the last index.

# For example:
# A = [2,3,1,1,4], return true.

# A = [3,2,1,0,4], return false.
''' 
Created on May 17, 2013
@author: Yubin Bai
'''


def jumpGame(array):
    def _jumpGame(array, currPos):
        if currPos in memo:
            return memo[currPos]
        if currPos == len(array) - 1:
            memo[currPos] = True
            return True
        for i in range(1, array[currPos] + 1):
            if _jumpGame(array, currPos + i):
                memo[currPos] = True
                return True
        memo[currPos] = False
        return False
    result = [False]
    memo = {}
    return _jumpGame(array, 0)


if __name__ == '__main__':
    data = [2, 3, 1, 1, 4]
    print(jumpGame(data))

    data = [3, 2, 1, 0, 4]
    print(jumpGame(data))
