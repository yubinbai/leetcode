# Given two integers n and k, return all possible combinations of k
# numbers out of 1 ... n.

# For example,
# If n = 4 and k = 2, a solution is:

# [
#   [2,4],
#   [3,4],
#   [2,3],
#   [1,2],
#   [1,3],
#   [1,4],
# ]


def combinations(n, k):
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

print combinations(5, 3)

print combinations(4, 2)
