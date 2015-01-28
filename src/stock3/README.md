Problem
===
Say you have an array for which the ith element is the price of a given
stock on day i.

Design an algorithm to find the maximum profit. You may complete at most
two transactions.

Solution
===
Divide list into two halves. For each half find one best transaction, and combine.

Note the edge case that one good transaction can make more money than two common ones