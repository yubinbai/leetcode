# Given a string, determine if it is a palindrome, considering only
# alphanumeric characters and ignoring cases.

# For example,
# "A man, a plan, a canal: Panama" is a palindrome.
# "race a car" is not a palindrome.

# Note:
# Have you consider that the string might be empty? This is a good
# question to ask during an interview.

# For the purpose of this problem, we define empty string as valid palindrome.

'''
Created on 2013-5-13
@author: Yubin Bai
'''
import re


def isPalindrome(s):
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
