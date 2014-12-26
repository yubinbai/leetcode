Problem
===

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

    "((()))", "(()())", "(())()", "()(())", "()()()"

Solution
===

Brute force, backtrack and prune impossible branch

memoize current left and right parentheses count (as parameters)
for fast condition eval