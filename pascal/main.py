'''
Created on 2013-5-13
@author: Yubin Bai
'''

if __name__ == '__main__':
    result = [[1]]
    level = 15

    n = 2
    prevRow = [1]
    while n != level + 1:
        currRow = [1]
        for i in range(1, n - 1):
            currRow.append(prevRow[i - 1] + prevRow[i])
        currRow.append(1)
        result.append(list(currRow))
        prevRow = currRow
        n += 1

    for row in result:
        print(row)
