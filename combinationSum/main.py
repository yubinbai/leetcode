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
    if target == 0:
        results.append(list(stack))
        return 
    if target < 0 or step == len(array):
        return
    
    # use the current value
    stack.append(array[step])
    _combinationSum(array, target - array[step], step, stack, results)
    stack.pop()
    
    # do not use the current value
    _combinationSum(array, target, step + 1, stack, results)
    
   
if __name__ == '__main__':
    data = [2, 3, 6, 7]
    target = 7
    combinationSum(data, target)
