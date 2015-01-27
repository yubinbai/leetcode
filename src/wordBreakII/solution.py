class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def wordBreak(self, s, dict):
        def _solve(step):
            if step == n:
                scopy = list(s)
                for x in stack[::-1]:
                    scopy.insert(x, ' ')
                scopy = ''.join(scopy)
                ret.append(scopy.strip())
            else:
                for i in xrange(step + 1, n + 1):
                    if possible[i] and s[step:i] in dict:
                        solution_count = len(ret)
                        stack.append(i)
                        _solve(i)
                        stack.pop()
                        if len(ret) <= solution_count:
                            possible[i] = 0

        n = len(s)
        ret = []
        stack = []
        possible = [1 for x in range(0, n + 1)]
        _solve(0) 
        return ret

if __name__ == '__main__':
    sol = Solution()
    # target = 'catsanddog'
    # dict = set(["cat", "cats", "and", "sand", "dog"])
    target = "aaaaaaaa"
    dict = set(["aaaa","aaa","aa"])
    for str in sol.wordBreak(target, dict):
        print str

