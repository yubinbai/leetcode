class Solution:
    # @param triangle, a list of lists of integers
    # @return an integer
    def minimumTotal(self, triangle):
        prev = list(triangle[-1])
        for rowI in range(len(triangle)-1, -1, -1):
            row = triangle[rowI]
            curr = []
            for i in range(prev):
                

        return 0

if __name__ == '__main__':
    tri = [[2], [3,4], [6,5,7], [4,1,8,3] ]
    s = Solution()
    print s.minimumTotal(tri)