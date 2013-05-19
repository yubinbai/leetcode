'''
Created on 2013-5-16

@author: Administrator
'''

def isScramble(s1, s2):
    memo = {}
    return _isScramble(s1, s2, 0, 0, len(s1), memo)

def _isScramble(s1, s2, s1Left, s2Left, length, memo):
    t = (s1Left, s2Left, length)
    if t in memo:
        return memo[t]
    if s1[s1Left:s1Left + length] == s2[s2Left:s2Left + length]:
        memo[t] = True
        return True
    
    for i in range(1, length):
        if _isScramble(s1, s2, s1Left, s2Left, i, memo) and \
                _isScramble(s1, s2, s1Left + i, s2Left + i, length - i, memo):
            memo[t] = True
            return True
        if _isScramble(s1, s2, s1Left, s2Left + length - i - 1, i, memo) and \
                _isScramble(s1, s2, s1Left + length - i - 1, s2Left, length - i, memo):
            memo[t] = True
            return True
    memo[t] = False
    return False
            

if __name__ == '__main__':
    print(isScramble('great', 'rgeat'))
    print(isScramble('great', 'rgtae'))
