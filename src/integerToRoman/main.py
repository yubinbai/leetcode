class Solution:
    # @return a string

    def intToRoman(self, num):
        romanNumbers = ["M", "CM", "D", "CD", "C",
                        "XC", "L", "XL", "X", "IX", "V", "IV", "I"]
        val = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1]

        converted = []
        for i in range(len(romanNumbers)):
            d, num = divmod(num, val[i])
            converted.append(romanNumbers[i] * d)
        return ''.join(converted)

if __name__ == '__main__':
    s = Solution()
    # for i in range(1, 200): print(s.intToRoman(i))
    print(s.intToRoman(400))
    print(s.intToRoman(1980))
    print(s.intToRoman(3999))
