'''
Created on May 16, 2013

@author: Administrator
'''


def combinationSum(array, target):
    '''
    find the way to get to sum target using
    combination of array elements
    '''
    def _combinationSum(target, step):
        if target == 0:
            results.append(list(stack))
            return
        if target < 0 or step == len(array):
            return

        # use the current value
        stack.append(array[step])
        _combinationSum(target - array[step], step)
        stack.pop()

        # do not use the current value
        _combinationSum(target, step + 1)

    results = []
    stack = []
    _combinationSum(target, 0)
    for i in results:
        print(i)


if __name__ == '__main__':
    data = [2, 3, 6, 7]
    target = 7
    combinationSum(data, target)
