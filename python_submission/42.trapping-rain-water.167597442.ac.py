class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        waterTrapped = 0
        left = 0
        right = len(height) - 1
        waterLevel = 0
        lowerBar = 0

        while(left < right):
            if height[left] < height[right]:
                lowerBar = height[left]
                left += 1
            else:
                lowerBar = height[right]
                right -= 1

            waterLevel = max(lowerBar, waterLevel )
            waterTrapped += waterLevel - lowerBar

        return waterTrapped

