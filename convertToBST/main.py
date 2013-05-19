'''
Created on May 15, 2013

@author: Administrator
'''
class ListNode:
    data = 0
    next = None
    def __init__(self, data=None):
        self.data = data

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
    data = None
    leftChild = None
    rightChild = None
    def __init__(self, data=None):
        self.data = data

# generate bst from linked list
def generateBST(head):
    size = 0
    curr = head
    while curr != None:
        curr = curr.next
        size += 1
    
    currListNode = [head]
    return _generateBST(0, size - 1, currListNode)

def _generateBST(left, right, currListNode):
    if left > right:
        return None
    mid = int((right - left) / 2) + left
    e = TreeNode(0)
    e.leftChild = _generateBST(left, mid - 1, currListNode)
    e.data = currListNode[0].data
    currListNode[0] = currListNode[0].next
    e.rightChild = _generateBST(mid + 1, right, currListNode)
    
    return e

def inOrder(root):
    result = []
    _inOrder(root, result)
    return result

def _inOrder(root, result):
    if root != None:
        _inOrder(root.leftChild, result)
        result.append(root.data)
        _inOrder(root.rightChild, result)
        
def postOrder(root):
    result = []
    _postOrder(root, result)
    return result

def _postOrder(root, result):
    if root != None:
        _postOrder(root.leftChild, result)
        _postOrder(root.rightChild, result)
        result.append(root.data)                
    
if __name__ == '__main__':
    data = list(range(1, 16))
    linked = generateLinkedList(data)
    
    tree = generateBST(linked)
    
    print(inOrder(tree))
    
    print(postOrder(tree))
    
