'''
Created on May 17, 2013
@author: Yubin Bai
'''


class Solution:
    # permute the sequence in place, allows duplicate elements
    # raise error if reached end of permutation
    # @param num, a list of integer
    # @return a list of integer

    def nextPermutation(self, num):
        size = len(num)
        if size <= 1:
            return num
        # 1.find the first acending order pair from the bottom
        low = size - 2
        high = size - 1
        while num[low] >= num[high]:
            if low == high - 1:
                low -= 1
                high = size - 1
                if low < 0:
                    break
            else:
                high -= 1
        if low < 0:
            num.sort()
            return num

        # 2.swap num[lo] with num[hi] if lo >= 0
        # print low, high
        num[low], num[high] = num[high], num[low]

        # 3.reverse lo+1 .. end
        num[low + 1:size] = num[size - 1:low:-1]
        return num

if __name__ == '__main__':
    seq = [1, 2, 2, 3]
    print(seq)
    s = Solution()
    for i in range(29):
        print s.nextPermutation(seq)
