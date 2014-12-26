class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers

    def spiralOrder(self, matrix):

        def printSpiralHelper(k, matrix, nSize, mSize):
            if mSize <= 0 or nSize <= 0:
                return

            if nSize == 1:
                for i in range(k, k + mSize):
                    result.append(matrix[k][i])
                return

            if mSize == 1:
                for i in range(k, k + nSize):
                    result.append(matrix[i][k])
                return

            # top
            for i in range(k, k + mSize):
                result.append(matrix[k][i])

            # right
            for i in range(k + 1, k + nSize):
                result.append(matrix[i][k + mSize - 1])

            # bottom
            for i in range(k + mSize - 2, k - 1, -1):
                result.append(matrix[k + nSize - 1][i])

            # left
            for i in range(k + nSize - 2, k, -1):
                result.append(matrix[i][k])

            printSpiralHelper(k + 1, matrix, nSize - 2, mSize - 2)

        result = []
        n = len(matrix)
        if n == 0:
            return result
        m = len(matrix[0])
        if m == 0:
            return result
        printSpiralHelper(0, matrix, n, m)
        return result


if __name__ == '__main__':

    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    # matrix = [[3], [2]]
    s = Solution()
    print s.spiralOrder(matrix)
