#include <iostream>

using namespace std;

// Manacher's algorithm

class Solution {
public:
	// Transform S into T.
	// For example, S = "abba", T = "^#a#b#b#a#$".
	// ^ and $ signs are sentinels appended to each end to avoid bounds checking
	string preProcess(string s) {
		int n = s.length();
		if (n == 0) return "^$";
		string ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.substr(i, 1);

		ret += "#$";
		return ret;
	}

	string longestPalindrome(string s) {
		string T = preProcess(s);
		int n = T.length();
		int *p = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i; // equals to i' = C - (i - C)

			p[i] = (R > i) ? min(R - i, p[i_mirror]) : 0;

			// Attempt to expand palindrome centered at i
			while (T[i + 1 + p[i]] == T[i - 1 - p[i]])
				p[i]++;

			// If palindrome centered at i expand past R,
			// adjust center based on expanded palindrome.
			if (i + p[i] > R) {
				C = i;
				R = i + p[i];
			}
		}

		// Find the maximum element in p.
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (p[i] > maxLen) {
				maxLen = p[i];
				centerIndex = i;
			}
		}
		delete[] p;

		return s.substr((centerIndex - 1 - maxLen) / 2, maxLen);
	}
};
// int main(int argc, char const *argv[])
// {
// 	Solution s;
// 	cout << s.longestPalindrome("abcdaaa");
// 	return 0;
// }