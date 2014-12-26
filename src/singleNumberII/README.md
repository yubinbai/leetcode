Problem
===
Given an array of integers, every element appears three times except for one.
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you
implement it without using extra memory?

idea: think of the final answer as the value that all bits count together
the result should be all bits in a certain position mod 3 == 1, the
corresponding value

Problem
===
Extend the xor trick, keep 'bit count mod 1' and 'bit count mod 2'