'''
Created on May 16, 2013

@author: Administrator
'''


def combinationSum(array, target):
    def _combinationSum(target, step):
        if target < 0 or step == len(array):
            return
        if target == 0:
            aResult = tuple(stack)
            if aResult not in results:
                results.append(aResult)
            return

        # use the current value
        stack.append(array[step])
        _combinationSum(target - array[step], step + 1)
        stack.pop()

        # do not use
        _combinationSum(target, step + 1)

    results = []
    stack = []
    _combinationSum(target, 0)
    for i in results:
        print(i)


if __name__ == '__main__':
    data = [10, 1, 2, 7, 6, 1, 5]
    data.sort()
    target = 8
    combinationSum(data, target)
