class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):

        def spiralHelper(k, matrix, nSize, mSize):
            if mSize <= 0 or nSize <= 0:
                return

            if nSize == 1:
                for i in range(k, k + mSize):
                    matrix[k][i] = curr[0]
                    curr[0] += 1
                return

            if mSize == 1:
                for i in range(k, k + nSize):
                    matrix[i][k] = curr[0]
                return

            # top
            for i in range(k, k + mSize):
                matrix[k][i] = curr[0]
                curr[0] += 1

            # right
            for i in range(k + 1, k + nSize):
                matrix[i][k + mSize - 1] = curr[0]
                curr[0] += 1

            # bottom
            for i in range(k + mSize - 2, k - 1, -1):
                matrix[k + nSize - 1][i] = curr[0]
                curr[0] += 1

            # left
            for i in range(k + nSize - 2, k, -1):
                matrix[i][k] = curr[0]
                curr[0] += 1

            spiralHelper(k + 1, matrix, nSize - 2, mSize - 2)

        matrix = [[0 for _ in range(n)] for _ in range(n)]
        curr = [1]

        spiralHelper(0, matrix, n, n)
        return matrix


if __name__ == '__main__':

    s = Solution()
    print s.generateMatrix(2)
    print s.generateMatrix(3)
    print s.generateMatrix(4)
