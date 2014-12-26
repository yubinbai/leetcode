# Definition for a  binary tree node
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        ret = []
        def visit(p):
            ret.append(p.val)

        p = root
        stack = []
        while p != None or stack:
            if p != None:
                stack.append(p)
                p = p.left
            else:
                p = stack.pop()
                visit(p)
                p = p.right

        return ret


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
    print s.inorderTraversal(root)
