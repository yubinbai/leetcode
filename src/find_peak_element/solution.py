class Solution:
    # @param num, a list of integer
    # @return an integer

    def findPeakElement(self, num):
        n = len(num)
        left, right = 0, len(num) - 1
        while left < right:
            mid = (left + right) >> 1
            if (mid == 0 or num[mid] > num[mid - 1]) and (mid == n - 1 or num[mid] > num[mid + 1]):
                return mid
            if mid > 0 and num[mid - 1] > num[mid]:
                right = mid - 1
            else:
                left = mid + 1
        return left

if __name__ == '__main__':
    arr = [0, 1, 2, 9, 7, 5, 4, 2, 1]
    s = Solution()
    print s.findPeakElement(arr)
