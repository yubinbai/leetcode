Binary Search Tree Iterator 
===

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Solution
===
Keep a stack and a current pointer, keep pushing node in stack when traversing into left tree

When poping from stack, output node value, and traverse the right subtree