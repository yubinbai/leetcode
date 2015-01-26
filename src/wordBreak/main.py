class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
        
        def dp(a, b):
            if (a, b) in memo:
                return memo[(a, b)]
            if s[a:b + 1] in hash_set:
                memo[(a, b)] = 1
                return 1
            for i in range(a, b):
                if dp(a, i) > 0 and dp(i + 1, b) > 0:
                    memo[(a, b)] = 1
                    return 1
            memo[(a, b)] = 0
            return 0

        n = len(s)
        memo = {}
        hash_set = set(dict)
        return dp(0, n - 1) > 0

if __name__ == '__main__':
    s = "leetcodeleetcodecode"
    d = ["leet", "code", "abacus"]
    sol = Solution()
    print sol.wordBreak(s, d)
