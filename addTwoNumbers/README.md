Problem
===

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


Solution
===

Similar to the 'add binary' problem, this is actually easier as the numbers are stored in reverse

Just keep track of carry and generate a new node for each digit