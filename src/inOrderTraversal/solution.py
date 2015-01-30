class Solution:
    # @param root, a tree node
    # @return a list of integers
    def inorderTraversal(self, root):
        def visit(p):
            ret.append(p.val)

        ret = []
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

    # @param root, a tree node
    # @return a list of integers
    def inorderTraversalRecursive(self, root):
        ret = []
        def trans(root):
            if root != None:
                trans(root.left)
                ret.append(root.val)
                trans(root.right)
        trans(root)
        return ret

# Definition for a binary tree node
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    @staticmethod
    def makeTree(A, i):
        if i >= len(A):
            return None
        node = TreeNode(A[i])
        # print node.val,
        node.left = TreeNode.makeTree(A, i * 2 + 1)
        node.right = TreeNode.makeTree(A, i * 2 + 2)
        return node

if __name__ == '__main__':
    t = [1, 2, 5, 3, 4, 0, 6]
    root = TreeNode.makeTree(t, 0)
    s = Solution()
    print s.inorderTraversal(root)
