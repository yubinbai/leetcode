class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        i = 0
        ii = 1
        N = len(A)
        count = 0
        while ii < N:
            if A[i] == A[ii] and i >= 1 and A[i] == A[i - 1]:
                ii += 1
                count += 1
            else:
                i += 1
                A[i] = A[ii]
                ii += 1
        # print A[:N - count]
        return N - count

if __name__ == '__main__':
    s = Solution()
    print s.removeDuplicates([1, 2, 2, 2, 2, 3, 4, 100, 100])

