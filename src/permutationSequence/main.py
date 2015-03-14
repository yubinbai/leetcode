class Solution:
    # @return a string

    def getPermutation(self, n, k):

        def nthPermutation(seq, index):
            # Returns the i- th permutation of seq (in proper order)
            seqc = list(seq[:])
            result = []
            fact = factorial[len(seq)]
            index %= fact
            while seqc:
                # get prev factorial
                fact = fact / len(seqc)
                # determine which one is picked
                choice, index = divmod(index, fact)
                # move to the result list
                result.append(seqc.pop(choice))
            return result

        word = ''.join(map(str, range(1, n + 1)))
        factorial = [1, 1]
        for i in range(2, 21):
            factorial.append(i * factorial[-1])
        return ''.join(nthPermutation(word, k - 1))

if __name__ == '__main__':
    sol = Solution()
    for x in xrange(1, 10):
        print sol.getPermutation(3, x)
