'''
Created on 2013-5-15

@author: Administrator
'''

def firstMissing(array):
    size = len(array)
    for cursor in range(size):
        target = array[cursor]
        while target <= size and target > 0 and target != array[target - 1]:
            newTarget = array[target - 1] 
            array[target - 1] = target
            target = newTarget
            
    for cursor in range(size):
        if cursor + 1 != array[cursor]:
            return cursor + 1
    return size + 1

def firstMissing2(array):
    size = len(array)
    for i in range(size):
        while array[i] <= size and array[i] > 0 and array[i] != array[array[i] - 1]:
            temp = array[array[i] - 1] 
            array[array[i] - 1] = array[i]
            array[i] = temp
            
    for cursor in range(size):
        if cursor + 1 != array[cursor]:
            return cursor + 1
    return size + 1

if __name__ == '__main__':
    data = [-1, 4, 2, 1, 0, -1, -1, 3]
    print(firstMissing(data))
    data = [-1, 4, 2, 1, 0, -1, -1, 3]
    print(firstMissing2(data))
