'''
Created on 2013-5-18

@author: Administrator
'''
def searchRange(array, key):
    left = 0
    right = len(array) - 1
    
    while left < right:
        mid = (left + right) // 2
        if key > array[mid]:
            left = mid + 1
        elif key < array[mid]:
            right = mid - 1 
        else:
            left = mid 
            while left >= 0 and array[left] == key:
                left -= 1
            right = mid
            while right < len(array) and array[right] == key:
                right += 1
            return left + 1, right - 1
    return -1, -1
 
if __name__ == '__main__':
    data = [5, 7, 7, 8, 8, 10]
    print(searchRange(data, 8))
    print(searchRange(data, 9))
    print(searchRange(data, 5))