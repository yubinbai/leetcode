class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        ret = []
        def visit(e):
            ret.append(e.val)

        stack = []
        p = root
        while p != None or stack:
            if p != None:
                if ret and ret[-1] == p.right:
                    visit(p)
                    p = None
                    continue
                stack.append(p)
                stack.append(p.right)
                p = p.left
            else:
                while p == None and stack:
                    p = stack.pop()
                visit(p)

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
    for e in s.postorderTraversal(root):
        print e,
