Problem
===
Given two binary strings, return their sum (also a binary string).

	For example,
	a = "11"
	b = "1"
	Return "100".

Solution
===
Scan from end of strings, keep track of carry, use StringBuilder