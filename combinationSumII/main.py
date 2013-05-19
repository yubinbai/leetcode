'''
Created on May 16, 2013

@author: Administrator
'''
def combinationSum(array, target):
    results = []
    stack = []
    _combinationSum(array, target, 0, stack, results)
    for i in results:
        print(i)
        
def _combinationSum(array, target, step, stack, results):
    if target < 0 or step == len(array):
        return
    if target == 0:
        aResult = tuple(stack)
        if aResult not in results:
            results.append(aResult)
        return 
    
    # use the current value
    stack.append(array[step])
    _combinationSum(array, target - array[step], step + 1, stack, results)
    stack.pop()
    
    # do not use
    _combinationSum(array, target, step + 1, stack, results)
    
if __name__ == '__main__':
    data = [10, 1, 2, 7, 6, 1, 5]
    data.sort()
    target = 8
    combinationSum(data, target)
