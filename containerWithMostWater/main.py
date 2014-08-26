# Given n non-negative integers a1, a2, ..., an, where each represents a
# point at coordinate (i, ai). n vertical lines are drawn such that the
# two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
# together with x-axis forms a container, such that the container contains
# the most water.

# Note: You may not slant the container.

class Solution:
    # @return an integer
    def maxArea(self, height):
        l, r = 0, len(height) - 1
        currMax = min(height[l], height[r]) * (r - l)
        while l < r:
            currMax = max(currMax, min(height[l], height[r]) * (r - l))
            if height[l] < height[r]:
                l += 1
            else:
                r -= 1
        return currMax
        
if __name__ == '__main__':
    s = Solution() 
    print s.maxArea([2, 4, 1, 3])
