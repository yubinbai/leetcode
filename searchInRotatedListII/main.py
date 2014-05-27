# Search in Rotated Sorted Array
# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# You are given a target value to search. If found in the array return its
# index, otherwise return -1.

# Follow up for "Search in Rotated Sorted Array":
# What if duplicates are allowed?

# Would this affect the run-time complexity? How and why?

# Write a function to determine if a given target is in the array.
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
