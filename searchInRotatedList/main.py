'''
Created on 2013-5-19

@author: Administrator
'''
def searchInRotated(array, key):
    left = 0
    right = len(array) - 1
    
    while left < right:
        mid = (left + right) // 2
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
