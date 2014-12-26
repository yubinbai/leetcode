Problem
===
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

Solution
===
Start from the end of A, fill bigger of A or B. Loop until pointers reach heads of arrays