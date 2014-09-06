'''
Created on 2013-5-19
@author: Yubin Bai
'''


class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return an integer

    def search(self, A, target):
        left = 0
        right = len(A) - 1
        while(left <= right):
            mid = (left + right) / 2
            if (A[mid] == target):
                return True
            if (A[left] < A[mid]):
                if (target >= A[left] and target < A[mid]):
                    right = mid - 1
                else:
                    left = mid + 1
            elif (A[left] > A[mid]):
                if (target > A[mid] and target <= A[right]):
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                left += 1
        return False


if __name__ == '__main__':
    s = Solution()
    data = [1, 3, 1, 1, 1]
    print(data)
    print(s.search(data, 3))
