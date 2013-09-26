'''
Created on 2013-5-19

@author: Yubin Bai
'''


def left(i):
    return 2 * i + 1


def right(i):
    return 2 * i + 2


def uniqueBST(length, result):
    if length == 0:
        result.append([])
        return
    if length == 1:
        result.append([1])
        return
    currTree = ['#' for x in range((1 << length) - 1)]

    for i in range(length):
        currTree[0] = i + 1
        leftTrees = []
        uniqueBST(i, leftTrees)

        rightTrees = []
        uniqueBST(length - 1 - i, rightTrees)

        for m in leftTrees:
            for n in rightTrees:
                transplant(currTree, left(0), m, 0)
                transplant(currTree, right(0), n, i + 1)
                result.append(list(currTree))
                maskM = ['#' for x in range(len(m))]
                maskN = ['#' for x in range(len(n))]
                transplant(currTree, left(0), maskM, 0)
                transplant(currTree, right(0), maskN, 0)


def transplant(treeList, rootPos, twigList, startValue):
    if len(twigList) > 0:
        _transplant(treeList, rootPos, twigList, 0, startValue)


def _transplant(treeList, rootPos, twigList, twigPos, startValue):
    if twigPos < len(twigList):
        if twigList[twigPos] != '#':
            treeList[rootPos] = twigList[twigPos] + startValue
        else:
            treeList[rootPos] = '#'
        _transplant(treeList, left(rootPos),
                    twigList, left(twigPos), startValue)
        _transplant(treeList, right(rootPos),
                    twigList, right(twigPos), startValue)

if __name__ == '__main__':
    result = []
    uniqueBST(3, result)
    for i in result:
        print(i)
    result = []
    uniqueBST(2, result)
    for i in result:
        print(i)
    result = []
    uniqueBST(4, result)
    for i in result:
        print(i)
