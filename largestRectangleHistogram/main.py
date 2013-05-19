'''
Created on May 15, 2013

@author: Administrator
'''
def largestRectangle(data):
    size = len(data)
    maxRect = [-1, 0, 0]
    _largestRectangle(data, 0, size - 1, maxRect)
    return maxRect

def _largestRectangle(data, left, right, maxRect):
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
    _largestRectangle(data, left, currMinPos - 1, max1)
    if maxRect[0] < max1[0]:
        maxRect[0], maxRect[1], maxRect[2] = max1[0], max1[1], max1[2]
     
    max2 = [-1, 0, 0]
    _largestRectangle(data, currMinPos + 1, right, max2)
    if maxRect[0] < max2[0]:
        maxRect[0], maxRect[1], maxRect[2] = max2[0], max2[1], max2[2]

if __name__ == '__main__':
    data = [2, 1, 5, 6, 2, 3]
    print(largestRectangle(data))
