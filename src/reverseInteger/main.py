class Solution:
    # @return an integer
    def reverse(self, x):
        s = str(x)
        if s[0] == '-':
            return int("-" + s[-1:0:-1])
        else:
            return int(s[::-1])

s = Solution()
print s.reverse(123)
print s.reverse(-123)
