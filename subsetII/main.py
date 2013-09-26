'''
Created on May 16, 2013

@author: Yubin Bai
'''


def subsets(data):
    def _subsets(step):
        results.append(list(path))
        for i in range(step, len(data)):
            if i != step and data[i] == data[i - 1]:
                continue
            path.append(data[i])
            _subsets(i + 1)
            path.pop()
    data.sort()
    results = []
    path = []
    _subsets(0)
    for i in results:
        print(i)


if __name__ == '__main__':
    data = [1, 1, 2]
    subsets(data)
