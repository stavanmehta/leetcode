class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if  len(nums) < 3:
            return -1
        pivot = 0
        end = 2
        foundSum = False
        while pivot < len(nums):
            if sum(nums[0:pivot]) == sum(nums[pivot+1:len(nums)]):
                return pivot
            pivot += 1
            end += 1
        return -1
