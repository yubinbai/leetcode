Problem
===
Given a string S, find the longest palindromic substring

Solution
===

For each index in string lenght, expand from center and find palindromes. O(n^2)

A more advanced solution is Manacher's solution, allowing reuse of previous matching result by mirroring. Complexity is O(n).

References:
[Leetcode explanation] (http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html)
[Chinese version] (http://www.felix021.com/blog/read.php?2040)

