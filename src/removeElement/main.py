# Given an array and a value, remove all instances of that value in place
# and return the new length.

# The order of elements can be changed. It doesn't matter what you leave
# beyond the new length.

'''
Created on 2013-5-16
@author: Yubin Bai
'''


class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer

    def removeElement(self, A, elem):
        counter = left = right = 0
        for right in range(len(A)):
            if A[right] != elem:
                if left != right:
                    A[left] = A[right]
                left += 1
            else:
                counter += 1
        # remove rest of list
        for _ in range(counter):
            A.pop()
        return left

if __name__ == '__main__':
    s = Solution()
    A = [1, 2, 2, 3, 4, 5, 6, 1, 2, 2, 7]
    print(A)
    print("len = %d" % s.removeElement(A, 2))
    print(A)
