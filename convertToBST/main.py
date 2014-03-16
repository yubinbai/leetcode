# Given a singly linked list where elements are sorted in ascending order,
# convert it to a height balanced BST.

'''
Created on May 15, 2013
@author: Yubin Bai
'''


class ListNode:

    def __init__(self, data=None):
        self.data = data
        self.next = None


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


class TreeNode:

    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None


def generateBST(head):
    '''
     generate bst from linked list
    '''
    def _generateBST(left, right, currListNode):
        if left > right:
            return None
        mid = (left + right) // 2
        e = TreeNode(0)
        e.left = _generateBST(left, mid - 1, currListNode)
        e.data = currListNode[0].data
        currListNode[0] = currListNode[0].next
        e.right = _generateBST(mid + 1, right, currListNode)
        return e
    size = 0
    curr = head
    while curr != None:
        curr = curr.next
        size += 1
    currListNode = [head]
    return _generateBST(0, size - 1, currListNode)


def inOrder(root):
    def _inOrder(node):
        if node != None:
            _inOrder(node.left)
            result.append(node.data)
            _inOrder(node.right)
    result = []
    _inOrder(root)
    return result


def postOrder(root):
    def _postOrder(node):
        if node != None:
            _postOrder(node.left)
            _postOrder(node.right)
            result.append(node.data)
    result = []
    _postOrder(root)
    return result

if __name__ == '__main__':
    data = list(range(1, 16))
    linked = generateLinkedList(data)
    tree = generateBST(linked)
    print(inOrder(tree))
    print(postOrder(tree))
