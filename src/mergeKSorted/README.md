Problem
===
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Solution
====
Solution 1
---
Put all lists into a queue, while queue size is bigger than one, pop two lists from queue, merge them to one, and put back to queue. O(n lg k)


Solution 2
---
Maintain a heap of k elements, with invariant of every lists' top node 

For each iteration, pop the top node in the heap at each loop and add a new node from the same original list. O(n lg k)