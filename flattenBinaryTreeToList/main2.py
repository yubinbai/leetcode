# Definition for a  binary tree node
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return nothing, do it in place

    def flatten(self, root):
        stack = []
        p = root

        while (p != None or stack):

            if (p.right != None):
                stack.append(p.right)

            if (p.left != None):
                p.right = p.left
                p.left = None
            elif (stack):
                temp = stack.pop()
                p.right = temp

            p = p.right


def makeTree(A, i):
    if i >= len(A):
        return None
    node = TreeNode(A[i])
    # print node.val,
    node.left = makeTree(A, i * 2 + 1)
    node.right = makeTree(A, i * 2 + 2)
    return node


def preOrder(root):
    if root != None:
        print root.val,
        preOrder(root.left)
        preOrder(root.right)

if __name__ == '__main__':
    t = [1, 2, 5, 3, 4, 0, 6]
    root = makeTree(t, 0)
    # preOrder(root)
    s = Solution()
    s.flatten(root)
    while root.right != None:
        print root.val,
        root = root.right
    print root.val
