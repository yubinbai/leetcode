# The string "PAYPALISHIRING" is written in a zigzag pattern on a given
# number of rows like this: (you may want to display this pattern in a
# fixed font for better legibility)

# P   A   H   N
# A P L S I I G
# Y   I   R
# And then read line by line: "PAHNAPLSIIGYIR"
# Write the code that will take a string and make this conversion given a
# number of rows:

# string convert(string text, int nRows);
# convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


class Solution:
    # @return a string

    def convert(self, s, nRows):
        if nRows == 1:
            return s
        result = [[] for _ in range(nRows)]
        m = nRows * 2 - 2
        for i, c in enumerate(s):
            if i % m >= 0 and i % m < nRows:
                result[i % m].append(c)
            else:
                result[nRows - 2 - (i % m - nRows)].append(c)
        res = []
        for r in result:
            res.append(''.join(r))
        return ''.join(res)

if __name__ == '__main__':
    s = Solution()
    print s.convert("ABC", 2)
    print s.convert("PAYPALISHIRING", 3)
    print s.convert("twckwuyvbihajbmhmodminftgpdcbquupwflqfiunpuwtigfwjtgzzcfofjpydjnzqysvgmiyifrrlwpwpyvqadefmvfshsrxsltbxbziiqbvosufqpwsucyjyfbhauesgzvfdwnloojejdkzugsrksakzbrzxwudxpjaoyocpxhycrxwzrpllpwlsnkqlevjwejkfxmuwvsyopxpjmbuexfwksoywkhsqqevqtpoohpd", 4)
