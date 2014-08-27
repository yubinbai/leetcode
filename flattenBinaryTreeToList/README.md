Problem
===
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

	   1
	    \
	     2
	      \
	       3
	        \
	         4
	          \
	           5
	            \
	             6

Solution
===
Use pre-order transversal to determine seq

either use recursion or explicit stack to do the transversal

A little experiment displayed that leetcode use different test data for python and java