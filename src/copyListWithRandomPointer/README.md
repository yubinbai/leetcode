Problem
===
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Solution
===
Solution 1: O(n) time, O(n) space
Create hash map with entries (old\_node, new_node)

Connect edges afterwards

Solution 2: O(n) time, O(1) space

Copy in three passes:

1. copy all nodes and insert inside list

2. link the random pointer for copied

3. separate the copied to a new list
