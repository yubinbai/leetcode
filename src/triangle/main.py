class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        if len(triangle) == 0:
            return 0
        for rowI in range(len(triangle)-1, 0, -1):
            r = triangle[rowI]
            rr = triangle[rowI - 1]

            for i in range(len(rr)):
                rr[i] += min(r[i], r[i + 1])

        return triangle[0][0]

if __name__ == '__main__':
    tri = [[2], [3,4], [6,5,7], [4,1,8,3] ]
    s = Solution()
    print s.minimumTotal(tri)