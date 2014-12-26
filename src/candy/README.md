Problem
===
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.

    Children with a higher rating get more candies than their neighbors.

Solution
===
Give local minimum only 1

Scan from left to right, find increasing rating and mark as neighbor + 1

Scan from right to left, find increasing rating and mark as neighbor + 1

Find max of two candy #s
