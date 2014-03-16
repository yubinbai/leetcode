# Given a string s and a dictionary of words dict, determine if s can be
# segmented into a space-separated sequence of one or more dictionary
# words.

# For example, given
# s = "leetcode",
# dict = ["leet", "code"].

# Return true because "leetcode" can be segmented as "leet code".
import numpypy as np


def wordBreak(s, d):
    def dp(a, b):
        if memo[a, b] != -1:
            return memo[a, b]
        if s[a:b + 1] in d:
            memo[a, b] = 1
            return 1
        for i in range(a, b):
            if dp(a, i) and dp(i + 1, b):
                memo[a, b] = 1
                return 1
        memo[a, b] = 0
        return 0

    n = len(s)
    memo = np.zeros((n, n), dtype=np.int)
    memo.fill(-1)
    return dp(0, n - 1)


s = "leetcodeleetcodecode"
d = ["leet", "code", "abacus"]
print wordBreak(s, d)

s = "a" * 1000 + "b"
d = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
     "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]
print wordBreak(s, d)
