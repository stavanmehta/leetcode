class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        nums = nums1 + nums2
        nums.sort()
        print nums
        length = len(nums)
        if len(nums)%2 == 1:
            return nums[(length/2)]
        elif len(nums)%2 == 0:
            return (nums[(length/2)-1] + nums[(length/2)])/2.0
