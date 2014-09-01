'''
Created on 2013-5-16
@author: Yubin Bai
'''
import collections


class Solution:
    # @return a string

    def minWindow(self, S, T):
        target = collections.Counter(T)
        current = {}
        for i in target:
            current[i] = 0
        leftMin, rightMin, currMin = 0, 0, 1 << 33
        left = right = 0
        for right in range(len(S)):
            if S[right] in target:
                current[S[right]] += 1
            if all([current[x] >= target[x] for x in target]):
                while left <= right:
                    if S[left] not in target:
                        left += 1
                    elif current[S[left]] - target[S[left]] >= 1:
                        current[S[left]] -= 1
                        left += 1
                    else:  # cannot shorten more
                        break
                if currMin >= right - left + 1:
                    leftMin, rightMin, currMin = left, right, right - left + 1
        if currMin == 1 << 33:
            return ""
        else:
            return S[leftMin:rightMin + 1]

if __name__ == '__main__':
    S = "ADOBECODEBANC"
    T = "ABC"
    # S = "a"
    # T = "aa"
    # S = "a"
    # T = "b"
    s = Solution()
    print(s.minWindow(S, T))
