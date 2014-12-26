Problem
===
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Solution
===

Create hash map with entries (old\_node, new_node)

Connect edges afterwards