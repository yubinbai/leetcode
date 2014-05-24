class Solution:
    # @param x, an integer
    # @return an integer

    def sqrt(self, x):
        if x == 0:
            return 0
        if x == 1:
            return 1
        x0 = 1.0
        while True:
            x1 = (x0 + x / x0) / 2.0
            if (abs(x1 - x0) < 1):
                return int(x1)
            x0 = x1

if __name__ == '__main__':
    s = Solution()
    print s.sqrt(9)
