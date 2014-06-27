# Given a linked list, swap every two adjacent nodes and return its head.
# For example,
# Given 1->2->3->4, you should return the list as 2->1->4->3.
# Your algorithm should use only constant space. You may not modify the
# values in the list, only nodes itself can be changed.
'''
Created on 2013-5-20
@author: Yubin Bai
'''


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    # @param a ListNode
    # @return a ListNode
    def swapPairs(self, head):
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


def printList(head):
    curr = head
    result = []
    while curr != None:
        result.append(curr.val)
        curr = curr.next
    print(result)

if __name__ == '__main__':
    s = Solution()
    linked = ListNode(0)
    curr = linked
    for i in range(1, 5):
        curr.next = ListNode(i)
        curr = curr.next
    printList(linked)
    linked2 = s.swapPairs(linked)
    printList(linked2)
