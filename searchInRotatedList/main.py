# Search in Rotated Sorted Array
# Suppose a sorted array is rotated at some pivot unknown to you beforehand.

# (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

# You are given a target value to search. If found in the array return its
# index, otherwise return -1.

# You may assume no duplicate exists in the array.

'''
Created on 2013-5-19
@author: Yubin Bai
'''


def searchInRotated(array, key):
    left = 0
    right = len(array) - 1

    while left <= right:
        mid = (left + right) >> 1
        if key > array[mid]:
            if key > array[right]:
                right = mid - 1
            elif key < array[right]:
                left = mid + 1
            else:
                return right
        elif key < array[mid]:
            if key < array[left]:
                left = mid + 1
            elif key > array[left]:
                right = mid - 1
            else:
                return left
        else:
            return mid
    return -1

if __name__ == '__main__':
    data = list(range(6, 20)) + list(range(6))
    print(data)
    print(searchInRotated(data, 2))
    print(searchInRotated(data, 10))
    print(searchInRotated(data, 100))
