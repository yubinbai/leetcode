class Solution:
    # @return a list of strings, [s1, s2]

    def letterCombinations(self, digits):
        d = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']

        def _get(step):
            if step == N:
                ret.append(''.join(curr))
                return
            ind = int(digits[step])
            for c in d[ind]:
                curr.append(c)
                _get(step + 1)
                curr.pop()

        ret = []
        curr = []
        N = len(digits)
        _get(0)
        return ret

if __name__ == '__main__':
    s = Solution()
    print s.letterCombinations('23')
