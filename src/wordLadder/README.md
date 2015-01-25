Problem
===
Given two words (start and end), and a dictionary, find the length of
shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

Solution
===
BFS

Solution 1:
construct map from words' similarities, and store graph as array

Solution 2:
enumerate possible list of adjacent words during bfs expanding, and verify words by hashset