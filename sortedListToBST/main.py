# Definition for a  binary tree node
class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

# Definition for singly-linked list.


class ListNode:

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    # @param head, a list node
    # @return a tree node

    def sortedListToBST(self, head):
        def _generateBST(left, right):
            if left > right:
                return None
            mid = (left + right) // 2
            e = TreeNode(0)
            e.left = _generateBST(left, mid - 1)
            e.val = self.currListNode.val
            self.currListNode = self.currListNode.next
            e.right = _generateBST(mid + 1, right)
            return e
        size = 0
        curr = head
        while curr != None:
            curr = curr.next
            size += 1
        self.currListNode = head
        return _generateBST(0, size - 1)


def generateLinkedList(array):
    if len(array) == 0:
        return None
    head = ListNode(array[0])
    curr = head
    for i in range(1, len(array)):
        node = ListNode(array[i])
        curr.next = node
        curr = node
    return head


def inOrder(root):
    def _inOrder(node):
        if node != None:
            _inOrder(node.left)
            result.append(node.val)
            _inOrder(node.right)
    result = []
    _inOrder(root)
    return result


def postOrder(root):
    def _postOrder(node):
        if node != None:
            _postOrder(node.left)
            _postOrder(node.right)
            result.append(node.val)
    result = []
    _postOrder(root)
    return result

if __name__ == '__main__':
    val = list(range(1, 16))
    linked = generateLinkedList(val)
    sol = Solution()
    tree = sol.sortedListToBST(linked)
    print(inOrder(tree))
    print(postOrder(tree))
