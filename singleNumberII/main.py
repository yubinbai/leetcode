# Given an array of integers, every element appears three times except for one.
# Find that single one.

# Note:
# Your algorithm should have a linear runtime complexity. Could you
# implement it without using extra memory?
import operator

# idea: think of the final answer as the value that all bits count together
# the result should be all bits in a certain position mod 3 == 1, the
# corresponding value


def singleNumber(A):
    one = two = 0
    for a in A:
        one_ = (one ^ a) & ~two  # add up to bits mod 3 == 1
        two_ = (a & one) | (~a & two)  # add up to bits mod 3 == 2
        one = one_
        two = two_
    return one

A = [1, 1, 1, 3, 3, 3, 10000]
print singleNumber(A)
