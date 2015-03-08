class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of lists of integers

    def rotate(self, matrix):
        n = len(matrix)
        for x in range((n + 1) / 2):
            for y in range(n / 2):
                swap = matrix[x][y]
                matrix[x][y] = matrix[n - 1 - y][x]
                matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y]
                matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x]
                matrix[y][n - 1 - x] = swap
        return matrix


if __name__ == '__main__':
    s = Solution()
    matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    n = 3
    for i in range(3):
        print(matrix[i])
    s.rotate(matrix)
    for i in range(3):
        print(matrix[i])

    # print 'another way'
    # matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    # for i in range(3):
    #     print(matrix[i])
    # matrix = zip(*matrix[::-1])
    # for i in range(3):
    #     print(matrix[i])
