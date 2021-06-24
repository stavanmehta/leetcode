class Solution(object):
    def maxSubArrayLen(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        maxLength = 0
        sum = 0
        longestSubArray = 0
        
        for i in range(0, len(nums) - 1):
            for j in range(1, len(nums)):
                sum += nums[i] + nums[j]
                if sum == k:
                    if longestSubArray < j - i:
                        longestSubArray = j - i
                        print i, j
                    sum = 0
                elif sum > k:
                    sum = 0
        
        return longestSubArray            
                    
                    
