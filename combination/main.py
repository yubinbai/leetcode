class Solution:
    # @return a list of lists of integers

    def combine(self, n, k):
        results = []
        stack = []

        def comb(curr, step):
            if step == k:
                results.append(list(stack))
                return
            for i in range(curr, n + 1):
                stack.append(i)
                comb(i + 1, step + 1)
                stack.pop()

        comb(1, 0)
        return results

if __name__ == '__main__':
    s = Solution()
    print s.combine(1, 0)
    print s.combine(4, 2)
