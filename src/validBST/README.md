Problem
===

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

Solution
===
The left subtree of a node contains only nodes with keys **less than** the node's key.
The right subtree of a node contains only nodes with keys **greater than** the node's key.
Both the left and right subtrees must also be binary search trees.

Solution 2
===
Use an iterator of the binary search tree, and compare neighboring values.
