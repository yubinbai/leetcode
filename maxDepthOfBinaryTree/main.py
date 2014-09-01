# Definition for a binary tree node
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def generateBST(val):

    def generateBSTHelper(start, end):
        if start <= end:
            mid = int((start + end) / 2)
            root = TreeNode(val[mid])
            root.left = generateBSTHelper(start, mid - 1)
            root.right = generateBSTHelper(mid + 1, end)
            return root
        else:
            return None

    length = len(val)
    return generateBSTHelper(0, length - 1)


class Solution:
    # @param root, a tree node
    # @return an integer

    def maxDepth(self, root):
        if root == None:
            return 0
        stack = [root]
        maxDepth = 0
        prev = None
        while len(stack) > 0:
            curr = stack[-1]
            if prev == None or prev.left == curr or prev.right == curr:
                if curr.left != None:
                    stack.append(curr.left)
                elif curr.right != None:
                    stack.append(curr.right)
            elif curr.left == prev:
                if curr.right != None:
                    stack.append(curr.right)
            else:
                stack.pop()
            prev = curr
            if len(stack) > maxDepth:
                maxDepth = len(stack)
        return maxDepth


def maxDepthBFS(root):
    if root == None:
        return 0

    import collections
    q = collections.deque()
    currDepth = 1
    q.append([currDepth, root])
    while len(q) > 0:
        currDepth, curr = q.popleft()
        maxDepth = currDepth

        if curr.left != None:
            q.append([currDepth + 1, curr.left])
        if curr.right != None:
            q.append([currDepth + 1, curr.right])
    return maxDepth


if __name__ == '__main__':
    import random
    val = sorted([random.randint(1, 1000) for x in range(1023)])
    bst = generateBST(val)
    s = Solution()
    print(s.maxDepth(bst))
    print(maxDepthBFS(bst))
