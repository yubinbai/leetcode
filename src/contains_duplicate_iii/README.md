Problem
===

Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.

Solution
===

Maintain a treemap of max k nodes, binary search for possible matches. O(n log k)
