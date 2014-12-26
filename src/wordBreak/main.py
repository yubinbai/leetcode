# Given a string s and a dictionary of words dict, determine if s can be
# segmented into a space-separated sequence of one or more dictionary
# words.

# For example, given
# s = "leetcode",
# dict = ["leet", "code"].

# Return true because "leetcode" can be segmented as "leet code".
import numpy as np


def wordBreak(s, d):
    def dp(a, b):
        if memo[a, b] != -1:
            return memo[a, b]
        if s[a:b + 1] in d:
            memo[a, b] = 1
            return 1
        for i in range(a, b):
            if dp(a, i) > 0 and dp(i + 1, b) > 0:
                memo[a, b] = 1
                return 1
        memo[a, b] = 0
        return 0

    n = len(s)
    memo = np.zeros((n, n), dtype=np.int)
    memo.fill(-1)
    return dp(0, n - 1) > 0

if __name__ == '__main__':
    s = "leetcodeleetcodecode"
    d = ["leet", "code", "abacus"]
    print wordBreak(s, d)
