Problem
===

Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.


Solution
===

mergesort, divide & conquer

1. make incremental sums

2. Duing the merging step, for each [i] in the lower half, search for:

    j: the first index satisfy sums[j] - sums[i] > upper and
    k: the first index satisfy sums[k] - sums[i] >= lower.


Solution 2
===
binary indexed tree
http://bookshadow.com/weblog/2016/01/11/leetcode-count-of-range-sum/
