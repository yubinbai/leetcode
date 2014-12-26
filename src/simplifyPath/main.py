'''
Created on May 17, 2013
@author: Yubin Bai
'''


class Solution:
    # @param path, a string
    # @return a string

    def simplifyPath(self, path):

        path = path.split('/')
        result = []
        for i in path:
            if i in ['', '.']:
                continue
            elif i == '..':
                if len(result) > 0:
                    result.pop()
            else:
                result.append(i)
        return '/' + '/'.join(result)

if __name__ == '__main__':
    sol = Solution()
    print(sol.simplifyPath('/home/'))
    print(sol.simplifyPath('/..'))
    print(sol.simplifyPath('/a/./b/../../c/'))
