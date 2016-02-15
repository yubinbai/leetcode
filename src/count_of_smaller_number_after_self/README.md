Problem
===
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].

Solution
===

Binary index tree for inversion counting

1. normalize the numbers to 1..N
2. accumulate frequency at inversed order

http://pavelsimo.blogspot.com/2012/09/counting-inversions-in-array-using-BIT.html
