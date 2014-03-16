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


def convert(s, nRows):
    result = [[] for _ in range(nRows)]
    m = nRows + 1
    for i, c in enumerate(s):
        if i % m in range(nRows):
            result[i % m].append(c)
        else:
            result[nRows >> 1].append(c)
    res = []
    for r in result:
        res.append(''.join(r))
    return ''.join(res)


print convert("PAYPALISHIRING", 3)
