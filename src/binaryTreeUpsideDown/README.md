Problem
===
Binary Tree Upside Down
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
For example:
Given a binary tree {1,2,3,4,5},

	    1
	   / \
	  2   3
	 / \
	4   5
return the root of the binary tree [4,5,2,#,#,3,1].

	   4
	  / \
	 5   2
	    / \
	   3   1  

Solution
===
Keep a stack of parents, rearrage from bottom to up

Solution 2
===
a more complicated 'reverse linked list'

1. reverse the root->left links when going down the left subtree

2. rearrange the reversed tree to the desired form