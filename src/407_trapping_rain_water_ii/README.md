Problem
===

407. Trapping Rain Water II
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 

Example 1:


Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.

We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
Example 2:


Input: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
Output: 10
 

Constraints:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104

Solution
===

[2022-11-17 Thu] Learnings
Consider the boundary condition first. Then find a way to iterate. I spent a long time trying to find the result from inside out, this turned out to be a dead end.

Solution 1;
Dijkstra algorithm, use four borders as the source node. find the allowed heights inside.
Use the water level as the 'distance' for shortest path. 
The transition formula is same: 
>  h[i][j] = max(heightMap[i][j], min(h[i-1][j], h[i+1][j], h[i][j-1], h[i][j +1]))

Solution 2: 
Use bfs to simulate the water falling process.
Start from the outer-most cells, the water will fall out first to the height.
Update the changed tiles to be lower than the neighboring cells.
Record the final water level.
