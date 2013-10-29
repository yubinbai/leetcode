# Given a string s1, we may represent it as a binary tree by partitioning
# it to two non-empty substrings recursively.

# Below is one possible representation of s1 = "great":

#     great
#    /    \
#   gr    eat
#  / \    /  \
# g   r  e   at
#            / \
#           a   t
# To scramble the string, we may choose any non-leaf node and swap its two
# children.

# For example, if we choose the node "gr" and swap its two children, it
# produces a scrambled string "rgeat".

#     rgeat
#    /    \
#   rg    eat
#  / \    /  \
# r   g  e   at
#            / \
#           a   t
# We say that "rgeat" is a scrambled string of "great".

# Similarly, if we continue to swap the children of nodes "eat" and "at",
# it produces a scrambled string "rgtae".

#     rgtae
#    /    \
#   rg    tae
#  / \    /  \
# r   g  ta  e
#        / \
#       t   a
# We say that "rgtae" is a scrambled string of "great".

# Given two strings s1 and s2 of the same length, determine if s2 is a
# scrambled string of s1.


'''
Created on 2013-5-16

@author: Yubin Bai
'''


def isScramble(s1, s2):
    def _isScramble(s1Left, s2Left, length):
        '''
        starting s1Left and s2Left, decide whether the 
        substrings with length are scrambled
        '''
        t = (s1Left, s2Left, length)
        if t in memo:
            return memo[t]
        if s1[s1Left:s1Left + length] == s2[s2Left:s2Left + length]:
            memo[t] = True
            return True

        for i in range(1, length):
            if _isScramble(s1Left, s2Left, i) and \
                    _isScramble(s1Left + i, s2Left + i, length - i):
                memo[t] = True
                return True
            if _isScramble(s1Left, s2Left + length - i - 1, i) and \
                    _isScramble(s1Left + length - i - 1, s2Left, length - i):
                memo[t] = True
                return True
        memo[t] = False
        return False

    memo = {}
    return _isScramble(0, 0, len(s1))


if __name__ == '__main__':
    print(isScramble('great', 'rgeat'))
    print(isScramble('great', 'rgtae'))
