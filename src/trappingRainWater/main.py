# Trapping Rain Water
# Given n non-negative integers representing an elevation map where the
# width of each bar is 1, compute how much water it is able to trap after
# raining.

# For example,
# Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


class Solution:
    # @param A, a list of integers
    # @return an integer
    def trap(self, A):
        N = len(A)
        if N <= 1:
            return 0
        leftMax = []
        currMax = A[0]
        for i in range(N):
            if A[i] > currMax:
                currMax = A[i]
            leftMax.append(currMax)

        rightMax = [None] * N
        currMax = A[-1]
        for i in reversed(range(N)):
            if A[i] > currMax:
                currMax = A[i]
            rightMax[i] = currMax

        return sum(min(leftMax[i], rightMax[i]) - A[i]
                   for i in range(N))

if __name__ == '__main__':
    s = Solution()
    A = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    print(s.trap(A))
