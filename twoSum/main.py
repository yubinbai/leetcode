class Solution:
    # @return a tuple, (index1, index2)

    def twoSum(self, num, target):
        arr = []
        for (i, a) in enumerate(num):
            arr.append((a, i + 1))
        arr.sort()
        left, right = 0, len(arr) - 1
        while (left < right):
            if (arr[left][0] + arr[right][0] < target):
                left += 1
            elif (arr[left][0] + arr[right][0] > target):
                right -= 1
            else:
                i1, i2 = arr[left][1], arr[right][1]
                return min(i1, i2), max(i1, i2)
        return 0, 0

if __name__ == '__main__':
    sol = Solution()
    print sol.twoSum([2, 7, 11, 15], 9)
