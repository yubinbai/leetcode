Problem
===

You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint continuous sections of board, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.

Solution
===

Two solutions:

1. Binary search for answer, use greedy method to validate each number

2. DP, state will be dp[step][number of painters]