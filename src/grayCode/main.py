class Solution:
    # @return a list of integers

    def grayCode(self, n):
        if n <= 0:
            return [0]
        ret = [0, 1]
        if n == 1:
            return ret

        for x in xrange(1, n):
            old = list(ret)
            new = old[::-1]
            for (i, a) in enumerate(new):
                new[i] = a + (1 << x)
            ret = old + new

        return ret

if __name__ == '__main__':
    s = Solution()
    print s.grayCode(1)
    print s.grayCode(2)
    print s.grayCode(3)
    print s.grayCode(10)
    print s.grayCode(30)
