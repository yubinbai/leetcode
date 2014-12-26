Problem
===
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3

But the following is not:

	    1
	   / \
	  2   2
	   \   \
	   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

Solution
===

For the iterative solution, use level order traversal and compare two queues