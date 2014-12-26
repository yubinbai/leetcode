# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        ret = []
        def trans(root):
            if root != None:
                ret.append(root.val)
                trans(root.left)
                trans(root.right)
        trans(root)
        return ret