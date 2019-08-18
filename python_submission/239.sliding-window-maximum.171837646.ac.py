class Solution(object):
    def maxSlidingWindow(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        result = []
        for index in xrange(len(nums)):
            if (index + k <= len(nums)):
                # print nums[index:index+k]
                # print max(nums[index:index+k])
                result.append(max(nums[index:index+k]))
        return result
        
