'''
Created on 2013-5-16

@author: Yubin Bai
'''
from collections import Counter


def minWindow(s, t):
    target = Counter(t)
    current = {}
    for i in target:
        current[i] = 0
    leftMin, rightMin, currMin = 0, 0, 1 << 33
    left = right = 0
    for right in range(len(s)):
        if s[right] in target:
            current[s[right]] += 1
        if all([current[x] >= target[x] for x in target]):
            while left <= right:
                if s[left] not in target:
                    left += 1
                elif current[s[left]] - target[s[left]] >= 1:
                    current[s[left]] -= 1
                    left += 1
                else:
                    break
            if currMin >= right - left + 1:
                leftMin, rightMin, currMin = left, right, right - left + 1

    return s[leftMin:rightMin + 1]

if __name__ == '__main__':
    S = "ADOBECODEBANC"
    T = "ABC"
    print(minWindow(S, T))
