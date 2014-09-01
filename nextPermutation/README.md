Problem
===
Next Permutation
Implement next permutation, which rearranges numbers into the
lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest
possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and
its corresponding outputs are in the right-hand column.

	1,2,3 => 1,3,2
	3,2,1 => 1,2,3
	1,1,5 => 1,5,1

Solution
===

Knuth's permutation algorithm

1.find the first acending order pair from the bottom

2.swap seq[lo] with seq[hi] if lo >= 0

3.reverse [lo+1 .. end]