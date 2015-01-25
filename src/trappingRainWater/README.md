Problem
===
Trapping Rain Water
Given n non-negative integers representing an elevation map where the
width of each bar is 1, compute how much water it is able to trap after
raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Solution
===

For each bar, the number it can hold depends on its left and right boundaries

Two scans of the array build these boundaries, and sum the results up

More, if using the idea of *contraction* in functional programming, this can be done with O(n) work and O(log n) time, if using multiple threads