import re
class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        return ' '.join(re.split('\s+', s)[::-1]).strip()

if __name__ == '__main__':
    s = Solution()
    print '___' + s.reverseWords('the sky is blue') + '___' 
    print '___' + s.reverseWords('   a   b ') + '___' 
    print '___' + s.reverseWords(' ') + '___' 
