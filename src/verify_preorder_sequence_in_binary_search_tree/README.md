Problem
===
Question:
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?

Solution
===

Iterate over each element and follow the steps below:

1. Push to stack till you get higher element than the topmost element of the stack.
2. If you find current value which is greater than the TOP of Stack, POP till you hit higher element, and also mark the last poped value, which is your variable (Left_Tree_Highest).
This variable is used to check whether the order is correct or not.
3. In all the steps, if you find current element lesser than Left_Tree_Highest, then your tree is not a Binary Search Tree and it should return “NO”.
4. If all the element traversed, and you have not hit “NO”, means given sequence follows the Binary Search Tree rule.