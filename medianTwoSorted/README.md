Problem
====
There are two sorted arrays A and B of size m and a.length respectively. Find
the median of the two sorted arrays. The overall run time complexity should
be O(log (m+n)).
 
Solution
===
Similar to finding the k-th smallest, the divide and conquer method is a natural approach to this problem. First, we choose Ai and Bj (the middle elements of A and B) where i and j are defined as m/2 and n/2. We made an observation that if Ai <= Bj, then the median must be somewhere between Ai and Bj (inclusive). Therefore, we could dispose a total of i elements from left of Ai and a total of n-j-1 elements to the right of Bj.

Please take extra caution not to dispose Ai or Bj, as we might need two middle values to calculate the median (it might also be possible that the two middle values are both in the same array). The case where Ai > Bj is similar.
 
 
Therefore, an important invariant we have to maintain is:
**The number of elements being disposed from each array must be the same.**
