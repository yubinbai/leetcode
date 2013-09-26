'''
Created on May 16, 2013

@author: Yubin Bai
'''


def uniquePermutations(array):
    def _uniquePermutations():
        if len(path) == len(array):
            results.append(list(path))
            return
        for i in range(len(array)):
            if used[i] or (i != 0 and array[i] == array[i - 1] and used[i - 1]):
                continue
            used[i] = True
            path.append(array[i])
            _uniquePermutations()
            used[i] = False
            path.pop()
            
    results = []
    used = [False for x in range(len(array))]
    path = []
    _uniquePermutations()
    for i in results:
        print(i)


if __name__ == '__main__':
    array = [1, 1, 2]
    uniquePermutations(array)
