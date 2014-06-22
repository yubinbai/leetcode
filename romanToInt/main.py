class Solution:
    # @return an integer
    def romanToInt(self, s):
        ret = 0

        for c in reversed(s):
            if c == 'I':
                if ret >= 5: 
                    ret -= 1
                else:
                    ret += 1
            elif c == 'V':
                if ret >= 10:
                    ret -= 5
                else:
                    ret += 5
            elif c == 'X':
                if ret >= 50:
                    ret -= 10
                else:
                    ret += 10
            elif c == 'L':
                if ret >= 100:
                    ret -= 50
                else:
                    ret += 50
            elif c == 'C':
                if ret >= 500:
                    ret -= 100
                else:
                    ret += 100
            elif c == 'D':
                ret += 500
            elif c == 'M':
                ret += 1000
        return ret

if __name__ == '__main__':
    s = Solution() 
    print(s.romanToInt('IV'))
    print(s.romanToInt('VI'))
    print(s.romanToInt('XCIX'))
    print(s.romanToInt('MMMCMXCIX'))
