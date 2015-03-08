# Given an array of non-negative integers, you are initially
# positioned at the first index of the array.

# Each element in the array represents your maximum jump length at that
# position.

# Determine how many steps you need to get to the end

# For example:
# A = [2,3,1,1,4], return true.

# A = [3,2,1,0,4], return false.

'''
Created on May 17, 2013
Yubin Bai
'''


class Solution:
    # @param A, a list of integers
    # @return an integer

    def jump(self, A):
        N = len(A)
        ans = 0
        last = 0  # max distance reached at ans
        curr = 0  # max distance reached at ans+1
        for i in range(N):
            if i > last:
                last = curr
                ans += 1
            curr = max(curr, i + A[i])
        return ans

if __name__ == '__main__':
    s = Solution()
    data = [2, 3, 1, 1, 4]
    print(s.jump(data))
