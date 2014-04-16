# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def postorderTraversal(self, root):
        ret = []
        def trans(root):
            if root != None:
                trans(root.left)
                trans(root.right)
                ret.append(root.val)
        trans(root)
        return ret