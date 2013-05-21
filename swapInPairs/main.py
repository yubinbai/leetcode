'''
Created on 2013-5-20

@author: Administrator
'''
class ListNode:
    next = None
    def __init__(self, value):
        self.value = value

def swapInPairs(head):
    if head == None:
        return None
    if head.next == None:
        return head
    prev = head
    curr = head.next
    newHead = curr
    
    # swap in pairs    
    while True:
        nextPrev = curr.next
        if nextPrev == None: # reached end of list
            curr.next = prev
            prev.next = None
            break
        nextCurr = nextPrev.next
        if nextCurr == None:
            curr.next = prev
            prev.next = nextPrev
            break
        curr.next = prev
        prev.next = nextCurr
        
        prev = nextPrev
        curr = nextCurr
    
    return newHead

def printList(head):
    curr = head
    result = []
    while curr != None:
        result.append(curr.value)
        curr = curr.next
    print(result)


if __name__ == '__main__':
    
    linked = ListNode(0)
    curr = linked
    for i in range(1, 6):
        curr.next = ListNode(i)
        curr = curr.next
    
    printList(linked)
        
    linked2 = swapInPairs(linked)
    
    printList(linked2)
    
    