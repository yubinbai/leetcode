class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer

    def search(self, A, target):
        left = 0
        right = len(A) - 1

        while left <= right:
            mid = (left + right) >> 1
            if target == A[mid]:
                return mid
            # print mid, A[mid], left, A[left], right, A[right], '..',
            if A[left] <= A[mid]:
                if A[left] <= target and target <= A[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if A[mid] < target and target <= A[right]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1

if __name__ == '__main__':
    s = Solution()
    data = [4, 5, 6, 7, 8, 1, 2, 3]
    print(data)
    print(s.search(data, 8))
    # print(s.search(data, 10))
    # print(s.search(data, 100))
