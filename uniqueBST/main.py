'''
Created on 2013-5-19

@author: Administrator
'''
memo = {0:1, 1:1}

def numOfUniqueBST(depth):
    if depth in memo:
        return memo[depth]
    currSum = 0
    for i in range(depth):
        currSum += numOfUniqueBST(i) * numOfUniqueBST(depth - 1 - i)
    memo[depth] = currSum
    return currSum

if __name__ == '__main__':
    print(numOfUniqueBST(3))
    print(numOfUniqueBST(4))
