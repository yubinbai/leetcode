'''
Created on 2013-5-16

@author: Yubin Bai
'''


def removeElement(data, x):
    left = right = 0
    for right in range(len(data)):
        if data[right] != x:
            if left != right:
                data[left] = data[right]
            left += 1
    return left

if __name__ == '__main__':
    data = [1, 2, 2, 3, 4, 5, 6, 7]
    print(data)
    print("len = %d" % removeElement(data, 2))
    print(data)
