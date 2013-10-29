# Validate if a given string is numeric.

# Some examples:
# "0" => true
# " 0.1 " => true
# "abc" => false
# "1 a" => false
# "2e10" => true
# Note: It is intended for the problem statement to be ambiguous. You
# should gather all requirements up front before implementing one.

'''
Created on May 17, 2013
@author: Yubin Bai
'''


def isValid(numberStr):
    s = numberStr.strip()
    import re
    m = re.match(r'([0-9]*\.?[0-9]*)([Ee][+-]?[0-9]+)?', s)
    if m:
        return m.start() == 0 and m.end() == len(s)
    else:
        return False
if __name__ == '__main__':
    data = ["0", " 0.1 ", "abc", "1 a", "2e10"]
    for i in data:
        print(isValid(i))
