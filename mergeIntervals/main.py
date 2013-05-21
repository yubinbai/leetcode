'''
Created on May 17, 2013

@author: Administrator
'''
def mergeIntervals(data, result):
    # sort the data by left
    from operator import itemgetter
    data = sorted(data, key=itemgetter(0))
    
    i1 = list(data[0])
    for i in range(1, len(data)):
        i2 = list(data[i])
        if i1[1] >= i2[0]:
            i1[1] = max(i1[1], i2[1])
        else:
            result.append(list(i1))
            i1 = list(i2)
    result.append(i1)
    
if __name__ == '__main__':
    data = [[1, 3], [2, 6], [8, 10], [15, 18]]
    result = []
    mergeIntervals(data, result)
    print(result)
