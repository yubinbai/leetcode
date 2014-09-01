Problem
===
Minimum Window Substring
Given a string S and a string T, find the minimum window in S which will
contain all the characters in T in complexity O(n).

	For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return
the emtpy string "".

If there are multiple such windows, you are guaranteed that there will
always be only one unique minimum window in S.

Solution
===

Sliding window, expand window while not all chars are present.

When new chars are added, reduce the window as mush as possible