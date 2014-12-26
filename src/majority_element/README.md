Majority element
===

Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Solution 1
===

Sort the array, the majority element will always be in the [n >> 1] slot

Solution 2
===

The Boyer-Moore Majority Vote Algorithm

	Iterate through the array, maintain a current candidate and a counter initialized to 0

	For each iteration:
    If the counter is 0, we set the current candidate to x and the counter to 1.
    If the counter is not 0, we increment or decrement the counter based on whether x is the current candidate.
