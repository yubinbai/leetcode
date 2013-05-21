'''
Created on May 17, 2013

@author: Administrator
'''
def nextPermutation(data):
    size = len(data)
    # find the largest i than can be increased
    i = size - 2
    while i != 0 and data[i] > data[i + 1]:
        i -= 1
    # increase data[i] by the smallest amount
    # a[j+1] > a[j+1] > ... a[n-1]
    l = size - 1
    while data[l] < data[i]:
        l -= 1
    swap(data, l, i)
    # reverse i+1 .. end
    k = i + 1
    l = size - 1
    while k < l:
        swap(data, k, l)
        k += 1
        l -= 1
    return data
    
def swap(array, i, j):
    temp = data[i]
    data[i] = data[j]
    data[j] = temp
    
if __name__ == '__main__':
    '''
    data = [1, 2, 3, 4]
    print(data)
    for i in range(23):
        print(nextPermutation(data))    
    '''
    data = [1, 4, 2, 3]
    print(data)
    print(nextPermutation(data))
