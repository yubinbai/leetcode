class Solution:
    # @return a string

    def longestCommonPrefix(self, strs):
        def commonPrefix(s1, s2):
            n = min(len(s1), len(s2))
            pref = []
            for i in range(n):
                if s1[i] != s2[i]:
                    break
                else:
                    pref.append(s1[i])
            return ''.join(pref)
        if len(strs) == 0:
            return ''
        return reduce(commonPrefix, strs)

if __name__ == '__main__':
    sol = Solution()
    s = ['abc', 'abcde', 'abcd', 'acd', 'aoo']
    print sol.longestCommonPrefix(s)
