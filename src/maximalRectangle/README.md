Problem
===
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

Solution
===

Very difficult problem, need to utilize the method in question "largest rectangle histogram"

1. make a new matrix, where each value is the number of consecutive '1's above it

2. apply "largest rectangle histogram" on each row

3. compare and return max from all rows