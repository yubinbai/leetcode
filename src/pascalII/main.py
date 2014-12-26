'''
Created on 2014-3-24
@author: Yubin Bai
'''
class Solution:
    # @return a list of lists of integers
    def getRow(self, rowIndex):
        if rowIndex == 0: 
            return [1]

        n = 2
        prevRow = [1]
        while n <= rowIndex + 1:
            currRow = [1]
            for i in range(1, n - 1):
                currRow.append(prevRow[i - 1] + prevRow[i])
            currRow.append(1)
            prevRow = currRow
            n += 1
        return prevRow

s = Solution()
for i in range(10):
    print s.getRow(i)