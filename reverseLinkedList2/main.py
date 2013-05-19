'''
Created on May 15, 2013

@author: Administrator
'''
class ListNode:
    data = 0
    next = None
    def __init__(self, data):
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

def reverseList(head, m, n):
    # pass m - 1 nodes 
    curr = head
    lastNode = None
    for counter in range(m - 1):
        lastNode = curr
        curr = curr.next                    

    # reverse list
    counter = n - m + 1
    oldList = curr.next
    newListHead = curr
    newListTail = curr
    curr = curr.next
    
    while counter > 1:
        curr = oldList
        oldList = curr.next
        curr.next = newListHead
        newListHead = curr
        counter -= 1
        
    # link the list back
    newListTail.next = oldList
    if lastNode == None:
        return newListHead
    else:
        lastNode.next = newListHead
        return head
    
def printLinkedList(curr):
    result = []
    while curr != None:
        result.append(curr.data)
        curr = curr.next
    print(result)
                  
if __name__ == '__main__':
    data = list(range(1, 20)) 
    linked = generateLinkedList(data)
    printLinkedList(linked)
    linked = reverseList(linked, 1, 14)
    printLinkedList(linked)
