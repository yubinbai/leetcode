'''
Created on May 14, 2013

@author: Yubin Bai
'''


class Node:
    data = None
    leftChild = None
    rightChild = None

    def __init__(self, data=None):
        self.data = data


def generateTreeFromArray(data):
    return generateTreeHelper(data, 0)


def generateTreeHelper(data, root):
    if root < len(data):
        r = Node(data[root])
        r.leftChild = generateTreeHelper(data, 2 * root + 1)
        r.rightChild = generateTreeHelper(data, 2 * root + 2)
        return r
    else:
        return None


def pathSum(root, total):

    def pathSumHelper(root, total):
        if root.leftChild == None and root.rightChild == None:
            if total == root.data:
                path.append(root.data)
                results.append(list(path))
                path.pop()
            return
        path.append(root.data)
        if root.leftChild != None:
            pathSumHelper(root.leftChild, total - root.data)
        if root.rightChild != None:
            pathSumHelper(root.rightChild, total - root.data)
        path.pop()

    results = []
    path = []
    pathSumHelper(root, total)
    print(results)


if __name__ == '__main__':
    data = [5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1]
    tree = generateTreeFromArray(data)
    pathSum(tree, 22)
