Problem
===
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Solution
===

Since it's a circular route, it should be viable if total gas > total cost

If viable, start point gurantee the curr gas >= curr cost

1. scan from first point as start

2. accumulate curr gas and cost

3. when curr gas <= curr cost, reset: start to next, curr gas to 0

4. repeat 1 until reach end