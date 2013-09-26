'''
Created on May 17, 2013

@author: Yubin Bai
'''


def simplify(pathStr):
    path = pathStr.split('/')
    result = []
    for i in path:
        if i in ['', '.']:
            continue
        elif i == '..' and len(result) > 0:
            result.pop()
        else:
            result.append(i)
    return '/' + '/'.join(result)

if __name__ == '__main__':
    print(simplify('/home/'))
    print(simplify('/a/./b/../../c/'))
