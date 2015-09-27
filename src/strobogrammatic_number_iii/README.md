Problem
===
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.
For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.
Note:
Because the range might be a large number, the low and high numbers are represented as string.
Understand the problem:
The idea would be very close to the previous problem. So we find all the strobogrammatic numbers between the length of low and high.

Note that when the n == low or n == high, we need to compare and make sure the strobogrammatic number we find is within the range.

Solution
===

1. Easy to find the numbers of a smaller length
2. For the numbers of same length but smaller than target, counting with construction-based pruning

Time: O(length(high_number))