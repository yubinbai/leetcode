# Given numRows, generate the first numRows of Pascal's triangle.

# For example, given numRows = 5,
# Return

# [
#      [1],
#     [1,1],
#    [1,2,1],
#   [1,3,3,1],
#  [1,4,6,4,1]
# ]

'''
Created on 2013-5-13
@author: Yubin Bai
'''
class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        if numRows == 0:
            return []
        result = [[1]]
        if numRows == 1:
            return result

        n = 2
        prevRow = [1]
        while n <= numRows:
            currRow = [1]
            for i in range(1, n - 1):
                currRow.append(prevRow[i - 1] + prevRow[i])
            currRow.append(1)
            result.append(list(currRow))
            prevRow = currRow
            n += 1
        return result
