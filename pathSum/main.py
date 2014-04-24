# Given a binary tree, find the path sum that matches
# the target value

'''
Created on May 14, 2013
@author: Yubin Bai
'''


class Node:
    val = left = right = None

    def __init__(self, val=None):
        self.val = val


def generateTreeFromArray(val):
    def generateTreeHelper(val, root):
        if root < len(val):
            r = Node(val[root])
            r.left = generateTreeHelper(val, 2 * root + 1)
            r.right = generateTreeHelper(val, 2 * root + 2)
            return r
        else:
            return None
    return generateTreeHelper(val, 0)


class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        def pathSumHelper(root, sum):
            if root.left == None and root.right == None:
                if sum == root.val:
                    path.append(root.val)
                    results.append(list(path))
                    path.pop()
                return
            path.append(root.val)
            if root.left != None:
                pathSumHelper(root.left, sum - root.val)
            if root.right != None:
                pathSumHelper(root.right, sum - root.val)
            path.pop()

        if root == None:
            return False
        results = []
        path = []
        pathSumHelper(root, sum)
        return len(results) > 0


if __name__ == '__main__':
    val = [5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 0, 0, 5, 1]
    tree = generateTreeFromArray(val)
    s = Solution()
    print s.hasPathSum(tree, 22)
