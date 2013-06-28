'''
Created on 2013-5-20

@author: Administrator
'''
class ListNode:
    next = None
    def __init__(self, value):
        self.value = value
        
def generateList(data):
    if len(data) == 0:
        return None
    head = ListNode(data[0])
    curr = head
    for i in range(1, len(data)):
        curr.next = ListNode(data[i])
        curr = curr.next
    return head
    
def printList(head):
    curr = head
    result = []
    while curr != None:
        result.append(curr.value)
        curr = curr.next
    print(result)
    
def reverseKgroup(head, k):
    if head == None:
        return None
    
    newListHead = head
    newListTail = None
    
    currHead = head
    currTail = head
    counter = 1
    while currHead != None:
        currTemp = currHead
        currHead = currHead.next
        
        if counter == k:
            nextHead, nextTail = reverse(currTail, currTemp)
            if newListHead == head:
                newListHead = nextHead
                newListTail = nextTail
                nextTail.next = None
            else:
                newListTail.next = nextHead
                newListTail = nextTail
                newListTail.next = None
            currTail = currHead
            counter = 0
        
        counter += 1
    if newListTail != None:
        newListTail.next = currTail
    return newListHead

def reverse(head, tail):
    if head == None:
        return None
    if head == tail:
        return head
    oldList = head.next
    newListHead = head
    
    while oldList != tail:
        curr = oldList
        oldList = curr.next
        curr.next = newListHead
        newListHead = curr
    tail.next = newListHead
    return tail, head        
    
if __name__ == '__main__':
    data = list(range(10))
    linked = generateList(data)
    printList(linked)
    linked2 = reverseKgroup(linked, 5)
    printList(linked2)