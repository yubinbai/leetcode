# Given a linked list, swap every two adjacent nodes and return its head.
# For example,
# Given 1->2->3->4, you should return the list as 2->1->4->3.
# Your algorithm should use only constant space. You may not modify the
# values in the list, only nodes itself can be changed

def swapInPairs(head):
    if head == None:
        return None
    if head.next == None:
        return head
    prev = head
    curr = head.next
    newHead = curr

    while True:
        nextPrev = curr.next
        if nextPrev == None:  # reached end of list
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
