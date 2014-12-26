Problem
===

Given a list, rotate the list to the right by k places, where k is non-negative.

    For example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.

Solution
===

Count the length of list, break list into two lists and cat.

Alternatively, keep a second pointer while scan the list, find the last k elements in one scan