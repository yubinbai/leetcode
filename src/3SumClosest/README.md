Problem
===

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, *target*. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Solution
====
 
Same as 3 sum. Complexity O(n^2)

1. sort the array

2. iterate first selection in [0, length - 2)

3. use two pointers sliding to find the smallest in the enumerations of *two sums*
