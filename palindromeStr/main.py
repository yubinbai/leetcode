'''
Created on 2013-5-13

@author: Administrator
'''
def isPalindrome(s):
    import re
    strList = re.findall('[a-zA-Z]', s)
    size = len(strList)
    for i in range(size):
        strList[i] = strList[i].lower()
    for i in range(int(size / 2)):
        if strList[i] != strList[size - 1 - i]:
            return False
    return True


if __name__ == '__main__':
    print(isPalindrome('A man, a plan, a canal: Panama'))
    print(isPalindrome('race a car'))