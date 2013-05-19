'''
Created on May 16, 2013

@author: Administrator
'''
def subsets(data):
    results = []
    path = []
    _subsets(data, 0, path, results)
    for i in results:
        print(i)

def _subsets(data, step, path, results):
    results.append(list(path))
    
    for i in range(step, len(data)):
        if i != step and data[i] == data[i - 1]:
            continue
        
        path.append(data[i])
        _subsets(data, i + 1, path, results)
        path.pop()
        
if __name__ == '__main__':
    data = [1, 1, 2]
    subsets(data)
