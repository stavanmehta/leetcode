class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        start = 0
        end = len(nums)-1
        mid = int(round((end+start)/2))
        while mid != start or mid != end:
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                end = mid
                mid = int(round((end+start)/2))
            elif target > nums[mid]:
                start = mid
                mid = int(round((end+start)/2))
        return -1
