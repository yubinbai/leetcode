# Longest Common Prefix
# Write a function to find the longest common prefix string amongst an
# array of strings.


def commonPrefix(s1, s2):
    n = min(len(s1), len(s2))
    pref = []
    for i in range(n):
        if s1[i] != s2[i]:
            break
        else:
            pref.append(s1[i])
    return ''.join(pref)


def longestCommon(s):
    return reduce(commonPrefix, s)

s = ['abc', 'abcde', 'abcd', 'acd', 'oo']
print longestCommon(s)
