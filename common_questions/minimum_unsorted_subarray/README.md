Problem
===
Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to find that the subarray lies between the indexes 3 and 8.

2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that the subarray lies between the indexes 2 and 5.

Solution
===

O(n)
1. find first and last element that is not correct order

2. find min and max in the selected region

3. expand the selected region from the values in step 2