# Given a collection of integers that might contain duplicates, S,
# return all possible subsets.
# Note:
# Elements in a subset must be in non-descending order.
# The solution set must not contain duplicate subsets.
# For example,
# If S = [1,2,2], a solution is:
# [[2], [1], [1,2,2], [2,2], [1,2], [] ]

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
