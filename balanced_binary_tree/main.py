# Definition for a  binary tree node
import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        def _isBalanced(node):
            if node == None:
                return (True, 0, 0)
            else:
                r1, left1, right1 = _isBalanced(node.left)
                r2, left2, right2 = _isBalanced(node.right)
                left = max(left1, right1)
                right = max(left2, right2)
                if r1 and r2 and abs(left - right) <= 1:
                    return (True, left + 1, right + 1)
                else:
                    return (False, 0, 0)

        return _isBalanced(root)[0]      

if __name__ == '__main__':
    s = Solution()
    root = TreeNode(1)
    root.left = TreeNode(2)
    # root.left.left = TreeNode(4)
    print s.isBalanced(root)
