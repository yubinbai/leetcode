# There are N children standing in a line. Each child is assigned a rating
# value.

# You are giving candies to these children subjected to the following
# requirements:

# Each child must have at least one candy.
# Children with a higher rating get more candies than their neighbors.
# What is the minimum candies you must give?


def candy(ratings):
    ratings.sort()
    total = 0
    currR, currC = ratings[0], 1
    for r in ratings:
        if r > currR:
            currR = r
            currC += 1
        total += currC
    return total

ratings = [2, 3, 4, 4, 1, 1, 1]
print candy(ratings)
