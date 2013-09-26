'''
Created on 2013-5-19

@author: Yubin Bai
'''


def threeSumClosest(array, target):
    array.sort()
    size = len(array)
    result = [1 << 33, -1, -1, -1]  # a large number
    for first in range(size - 2):
        left = first + 1
        right = size - 1
        while left < right:
            curr = array[first] + array[left] + array[right]
            distance = abs(curr - target)
            if distance < result[0]:
                result = [distance, array[first], array[left], array[right]]
            if curr < target:
                left += 1
            else:
                right -= 1

    return result[1] + result[2] + result[3]


if __name__ == '__main__':
    data = [-1, 2, 1, -2]
    target = 1
    print(threeSumClosest(data, target))
