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

        def traversal(root):
            if root != None:
                traversal(root.left)
                traversal(root.right)
                ret.append(root.val)
        traversal(root)
        return ret
