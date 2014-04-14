class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        aBin = int(a, 2)       
        bBin = int(b, 2)
        return bin(aBin + bBin)[2:]

s = Solution()
print s.addBinary("11", "1")