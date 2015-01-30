class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        d = {}
        for s in strs:
            sortedS = ''.join(sorted(s))
            if sortedS in d:
                d[sortedS].append(s)
            else:
                d[sortedS] = [s]
        ret = []
        for k in d:
            if len(d[k]) > 1:
                ret.extend(d[k])
        return ret

if __name__ == '__main__':
    s = Solution()
    strs = ['bac', 'bb', 'bb', 'abc', 'ss']
    print s.anagrams(strs)