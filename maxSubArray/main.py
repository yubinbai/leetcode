class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        # kadane's dynamic programming algorithm
        maxSum = -1 * (1 << 30)
        currSum = maxSum
        for a in A:
            currSum = max(a, a + currSum)
            maxSum = max(maxSum, currSum)
        return maxSum


def kadane(array):
    # kadane's dynamic programming algorithm
    maxL, maxR, maxSum = -1, -1, 0.0
    currL, currR, currSum = 0, 0, 0.0
    for i, a in enumerate(array):
        if currSum < 0:
            currL, currR, currSum = i, i + 1, a
        else:
            currR, currSum = i + 1, currSum + a
        if maxSum < currSum:
            maxL, maxR, maxSum = currL, currR, currSum
    return maxL, maxR, maxSum


def kadane2(array):
    # kadane's dynamic programming algorithm
    maxSum = 0.0
    currSum = 0.0
    for a in array:
        currSum = max(a, a + currSum)
        maxSum = max(maxSum, currSum)
    return maxSum

if __name__ == '__main__':
    s = Solution()
    print s.maxSubArray([-2,1,-3,4,-1,2,1,-5,4])
    print s.maxSubArray([-1])
    print kadane([-1])
    print kadane2([-1])
