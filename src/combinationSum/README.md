Problem
===
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.

Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

The solution set must not contain duplicate combinations.

	For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 

	[7] 
	[2, 2, 3] 

Solution
===

Backtrack, carry partial results in parameters