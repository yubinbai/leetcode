# Reverse a linked list from position m to n. Do it in-place and in one-pass.

# For example:
# Given 1->2->3->4->5->NULL, m = 2 and n = 4,

# return 1->4->3->2->5->NULL.

# Note:
# Given m, n satisfy the following condition:
# 1 ≤ m ≤ n ≤ length of list.

'''
Created on May 15, 2013

@author: Yubin Bai
'''


class ListNode:
    data = next = None

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


def printLinkedList(curr):
    result = []
    while curr != None:
        result.append(curr.data)
        curr = curr.next
    print(result)


def reverseList(head, m, n):
    # pass m - 1 nodes
    curr = head
    prev = None
    for _ in range(m - 1):
        prev = curr
        curr = curr.next

    # reverse list
    counter = n - m + 1
    oldList = curr.next
    newListHead = curr
    newListTail = curr

    while counter > 1:
        curr = oldList
        oldList = curr.next
        curr.next = newListHead
        newListHead = curr
        counter -= 1

    # link the list back
    newListTail.next = oldList
    if prev == None:
        return newListHead
    else:
        prev.next = newListHead
        return head

if __name__ == '__main__':
    data = list(range(1, 20))
    linked = generateLinkedList(data)
    printLinkedList(linked)
    linked = reverseList(linked, 4, 14)
    printLinkedList(linked)
