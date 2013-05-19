'''
Created on May 16, 2013

@author: Administrator
'''
def uniquePermutations(array):
    results = []
    used = [False for x in range(len(array))]
    path = []
    _uniquePermutations(array, used, path, results)
    for i in  results:
        print(i)

def _uniquePermutations(array, used, path, results):
    if len(path) == len(array):
        results.append(list(path))
        return

    for i in range(len(array)):
        if used[i] or (i != 0 and array[i] == array[i - 1] and used[i - 1]):
            continue
        used[i] = True
        path.append(array[i])
        _uniquePermutations(array, used, path, results)
        used[i] = False
        path.pop()
            
def swap(array, i, j):
    temp = array[i]
    array[i] = array[j]
    array[j] = temp
     
if __name__ == '__main__':
    array = [1, 1, 2, ]
    uniquePermutations(array)
