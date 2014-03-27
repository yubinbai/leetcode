# Given a string, determine if it is a palindrome, considering only
# alphanumeric characters and ignoring cases.

# For example,
# "A man, a plan, a canal: Panama" is a palindrome.
# "race a car" is not a palindrome.

# Note:
# Have you consider that the string might be empty? This is a good
# question to ask during an interview.

# For the purpose of this problem, we define empty string as valid palindrome.
import re
class Solution:
    # @param s, a string
    # @return a boolean
    def isPalindrome(self, s):
        strList = re.findall('[0-9a-zA-Z]', s)
        size = len(strList)
        for i in range(size):
            strList[i] = strList[i].lower()
        for i in range(int(size / 2)):
            if strList[i] != strList[size - 1 - i]:
                return False
        return True


if __name__ == '__main__':
    s = Solution()
    print(s.isPalindrome('A man, a plan, a canal: Panama'))
    print(s.isPalindrome('1a2'))
    print(s.isPalindrome('race a car'))
