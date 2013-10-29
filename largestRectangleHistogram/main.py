# Given n non-negative integers representing the histogram's bar height
# where the width of each bar is 1, find the area of largest rectangle in
# the histogram.


# Above is a histogram where width of each bar is 1, given height =
# [2,1,5,6,2,3].


# The largest rectangle is shown in the shaded area, which has area = 10 unit.

# For example,
# Given height = [2,1,5,6,2,3]
# return 10.

'''
Created on May 15, 2013
@author: Yubin Bai
'''


def largestRectangle(data):
    def _largestRectangle(left, right, maxRect):
        if left > right:
            return
        currMin = data[left]
        currMinPos = left
        for i in range(left, right + 1):
            if currMin > data[i]:
                currMin = data[i]
                currMinPos = i
        maxRect[0] = currMin * (right - left + 1)
        maxRect[1], maxRect[2] = left, right

        max1 = [-1, 0, 0]
        _largestRectangle(left, currMinPos - 1, max1)
        if maxRect[0] < max1[0]:
            maxRect[0], maxRect[1], maxRect[2] = max1[0], max1[1], max1[2]

        max2 = [-1, 0, 0]
        _largestRectangle(currMinPos + 1, right, max2)
        if maxRect[0] < max2[0]:
            maxRect[0], maxRect[1], maxRect[2] = max2[0], max2[1], max2[2]

    size = len(data)
    maxRect = [-1, 0, 0]
    _largestRectangle(0, size - 1, maxRect)
    return maxRect


if __name__ == '__main__':
    array = [2, 1, 5, 6, 2, 3]
    print(largestRectangle(array)[0])
