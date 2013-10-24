# Given a string s and a dictionary of words dict, determine if s can be
# segmented into a space-separated sequence of one or more dictionary
# words.

# For example, given
# s = "leetcode",
# dict = ["leet", "code"].

# Return true because "leetcode" can be segmented as "leet code".
import numpypy as np


def wordBreak(s, d):
    n = len(s)
    match = np.zeros((n + 1, n + 1), dtype=np.byte)
    for i in range(n):
        for j in range(n + 1):
            if s[i:j] in d:
                match[i, j] = 1
    memo = [-1] * (n + 1)

    def dfs(idx):
        if memo[idx] != -1:
            return memo[idx]
        if idx >= n:
            memo[idx] = 1
            return 1
        result = 0
        for i in range(idx + 1, n + 1):
            if match[idx, i]:
                result |= dfs(i)
        memo[idx] = result
        return result

    return dfs(0)


s = "leetcodeleetcodecode"
d = ["leet", "code", "abacus"]

s = "a" * 1000 + "b"
d = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa",
     "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"]
print wordBreak(s, d)
