# Partition List
# Given a linked list and a value x, partition it such that all nodes less
# than x come before nodes greater than or equal to x.

# You should preserve the original relative order of the nodes in each of
# the two partitions.

# For example,
# Given 1->4->3->2->5->2 and x = 3,
# return 1->2->2->4->3->5.
'''
Created on Oct 28, 2013
@author: Yubin Bai
'''


def partition(head, x):
    tail1 = head1 = ListNode()
    tail2 = head2 = ListNode()
    curr = head
    while curr:
        if curr.value < x:
            tail1.next = curr
            curr = curr.next
            tail1 = tail1.next
        else:
            tail2.next = curr
            curr = curr.next
            tail2 = tail2.next
    tail1.next = head2.next
    tail2.next = None
    return head1.next


class ListNode:

    def __init__(self, value=None):
        self.value = value
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


def printList(head):
    curr = head
    result = []
    while curr != None:
        result.append(curr.value)
        curr = curr.next
    print(result)


if __name__ == '__main__':
    value = [1, 4, 3, 2, 5, 2]
    linked = generateLinkedList(value)
    newLinked = partition(linked, 3)
    printList(newLinked)
