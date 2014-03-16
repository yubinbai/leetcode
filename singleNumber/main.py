# Given an array of integers, every element appears twice except for one.
# Find that single one.

# Note:
# Your algorithm should have a linear runtime complexity. Could you
# implement it without using extra memory?
import operator


def singleNumber(A):
    return reduce(operator.xor, A)

A = [1, 1, 3, 3, 10000]
print singleNumber(A)
