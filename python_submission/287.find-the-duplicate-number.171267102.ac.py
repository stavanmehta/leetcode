class Solution(object):
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # return (sum(nums) - sum(set(nums))) // (len(nums) - len(set(nums)))
        from collections import Counter
        numDict = Counter(nums)
        for key, value in numDict.items():
            if value > 1:
                return key
