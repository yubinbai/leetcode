'''
Created on 2013-5-16

@author: Yubin Bai
'''
class Solution:
    # @return a boolean
    def isScramble(self, s1, s2):
        # starting left1 and left2, decide whether the substrings with length are scrambled
        def _isScramble(left1, left2, length):
            t = (left1, left2, length)
            if t in memo:
                return memo[t]
            if s1[left1:left1 + length] == s2[left2:left2 + length]:
                memo[t] = True
                return True

            for i in range(1, length):
                if _isScramble(left1, left2, i) and _isScramble(left1 + i, left2 + i, length - i):
                    memo[t] = True
                    return True
                if _isScramble(left1, left2 + length - i, i) and _isScramble(left1 + i, left2, length - i):
                    memo[t] = True
                    return True
            memo[t] = False
            return False

        memo = {}
        ret = _isScramble(0, 0, len(s1))
        # for k in memo: print k, memo[k]
        return ret

if __name__ == '__main__':
    sol = Solution()
    # print(sol.isScramble('great', 'rgeat'))
    # print(sol.isScramble('ba', 'ab'))

    print(sol.isScramble('eat', 'tae'))
    # print(sol.isScramble('great', 'rgtae'))
