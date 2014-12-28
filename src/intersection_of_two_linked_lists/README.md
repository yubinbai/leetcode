Intersection of Two Linked Lists
===

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

	A:          a1 → a2
	                   ↘
	                     c1 → c2 → c3
	                   ↗            
	B:     b1 → b2 → b3

begin to intersect at node c1.

Solution
===

Traverse the lists to get the length of each of the lists. 

Traverse again at the point where they have equal length. Iterate over the two lists and stop at where they are equal.