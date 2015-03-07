Problem
===
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

	For example, given s = "aab",
	Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Solution
===

DP, function is min cuts between i and end. 

maintain a second dp array for isPalindrome(i, j), during the iteration 

dp[i] = min(dp[j + 1] + 1) for j in [i.. N - 1] and isPalindrome(i, j) == true

isPalindrome[i, j] = s[i] == s[j] && isPalindrome[i + 1, j - 1]