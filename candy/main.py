class Solution:
    # TLE
    def candy(self, ratings):
        left = [1] * len(ratings)
        right = [1] * len(ratings)
        for i in range(1, len(ratings)):
            if ratings[i - 1] < ratings[i]:
                left[i] = left[i - 1] + 1
     
        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i + 1] < ratings[i]:
                right[i] = right[i - 1] + 1
        print left
        print right
        total = 0
        for i in range(len(ratings)):
            total += max(left[i], right[i])
        return total
