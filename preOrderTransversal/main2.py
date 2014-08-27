class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        ret = []
        def visit(p):
            ret.append(p.val)

        stack = []
        p = root
        while (p != None or stack):
            if (p.right != None): 
                stack.append(p.right)
            visit(p)
            if (p.left != None):
                p = p.left
            elif (stack): 
                p = stack.pop()
            else:
                p = None
        return ret

def makeTree(A, i):
    if i >= len(A):
        return None
    node = TreeNode(A[i])
    # print node.val, 
    node.left = makeTree(A, i * 2 + 1)
    node.right = makeTree(A, i * 2 + 2)
    return node

if __name__ == '__main__':
    t = [1, 2, 5, 3, 4, 0, 6]
    root = makeTree(t, 0)
    s = Solution()
    for e in s.preorderTraversal(root):
        print e,
