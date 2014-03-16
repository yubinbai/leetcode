# Given an array and a value, remove all instances of that value in place
# and return the new length.

# The order of elements can be changed. It doesn't matter what you leave
# beyond the new length.

'''
Created on 2013-5-16
@author: Yubin Bai
'''


def removeElement(data, x):
    counter = left = right = 0
    for right in range(len(data)):
        if data[right] != x:
            if left != right:
                data[left] = data[right]
            left += 1
        else:
            counter += 1
    # remove rest of list
    for _ in range(counter):
        data.pop()
    return left

if __name__ == '__main__':
    data = [1, 2, 2, 3, 4, 5, 6, 1, 2, 2, 7]
    print(data)
    print("len = %d" % removeElement(data, 2))
    print(data)
