class Solution:
    # @param tokens, a list of string
    # @return an integer

    def evalRPN(self, tokens):
        stack = []
        for t in tokens:
            if t in ["+", "-", "*", "/"]:
                a = stack.pop()
                b = stack.pop()
                s = b + '.0' + t + '(' + a + '.0' + ')'
                res = eval(s)
                res = int(res)
                stack.append(str(res))
            else:
                stack.append(t)
        return int(stack[0])

if __name__ == '__main__':
    s = Solution()
    arr = ["2", "1", "+", "3", "*"]
    print s.evalRPN(arr)
    arr = ["4", "13", "5", "/", "+"]
    # arr = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    print s.evalRPN(arr)
