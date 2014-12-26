# Palindrome Number
# Determine whether an integer is a palindrome. Do this without extra space.

# Some hints:
# Could negative integers be palindromes? (ie, -1)

# If you are thinking of converting the integer to string, note the
# restriction of using extra space.

# You could also try reversing an integer. However, if you have solved the
# problem "Reverse Integer", you know that the reversed integer might
# overflow. How would you handle such case?

# There is a more generic way of solving this problem.


class Solution:
    # @return a boolean

    def isPalindrome(self, x):
        if x < 0:
            return False
        p10 = 1
        while (x / p10 >= 10):
            p10 *= 10
        while (x != 0):
            l = x / p10
            r = x % 10
            if (l != r):
                return False
            x = (x % p10) / 10
            p10 /= 100
        return True

if __name__ == '__main__':
    s = Solution()
    print s.isPalindrome(101)
