# Given an array S of n integers, are there elements a, b, c, and d in S
# such that a + b + c + d = target? Find all unique quadruplets in the
# array which gives the sum of target.

# Note:
# Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
# The solution set must not contain duplicate quadruplets.
#     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

#     A solution set is:
#     (-1,  0, 0, 1)
#     (-2, -1, 1, 2)
#     (-2,  0, 0, 2)


def fourSum(array, target):
    array.sort()
    n = len(array)
    sol = []
    for i in range(n - 3):
        for j in range(i + 1, n - 2):
            t = target - array[i] - array[j]
            left = j + 1
            right = n - 1
            while left < right:
                if array[left] + array[right] > t:
                    right -= 1
                elif array[left] + array[right] < t:
                    left += 1
                else:
                    sol.append((array[i], array[j], array[left], array[right]))
                    left += 1
    return sol

if __name__ == '__main__':
    array = [1, 0, -1, 0, -2, 2]
    print fourSum(array, 0)
