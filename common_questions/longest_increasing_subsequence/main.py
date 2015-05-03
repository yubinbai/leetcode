def longestIncreasingSubsequence(array):
    M = [0]
    P = [0] * len(array)
    P[0] = -1
    for i in range(1, len(array)):
        if array[M[-1]] < array[i]:
            P[i] = M[-1]
            M.append(i)
        else:
            low, high = 0, len(M) - 1
            while low < high:
                mid = (low + high) // 2
                if array[M[mid]] < array[i]:
                    low = mid + 1
                else:
                    high = mid
            # update if the new value is smaller
            if array[i] < array[M[low]]:
                if low > 0:
                    P[i] = M[low - 1]
                M[low] = i

    result = []
    p = M[-1]
    for i in range(len(M)):
        result.append(array[p])
        p = P[p]
    result.reverse()
    return len(result), result

if __name__ == '__main__':
    array = [1, 2, 3, 5, 4]
    print longestIncreasingSubsequence(array)

    array = [1, 2, 3, 4, 5, 10]
    print longestIncreasingSubsequence(array)
