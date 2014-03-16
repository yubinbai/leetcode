# Given n non-negative integers a1, a2, ..., an, where each represents a
# point at coordinate (i, ai). n vertical lines are drawn such that the
# two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
# together with x-axis forms a container, such that the container contains
# the most water.

# Note: You may not slant the container.


def maxArea(heights):
    l, r = 0, len(heights) - 1
    currMax = min(heights[l], heights[r]) * (r - l)
    while l < r:
        currMax = max(currMax, min(heights[l], heights[r]) * (r - l))
        if heights[l] < heights[r]:
            l += 1
        else:
            r -= 1
    return currMax

print maxArea([2, 4, 1, 3])
