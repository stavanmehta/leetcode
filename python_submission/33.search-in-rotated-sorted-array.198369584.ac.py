class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums)==0:
            return -1

        L = 0
        R = len(nums) - 1

        while True:
            if L>R: return -1
            tmpVar = (L+R)*1.0/2
            m = int(tmpVar - tmpVar%1)
            if nums[L]==target: return L
            if nums[R]==target: return R
            if nums[m]==target: return m

            if nums[L]<target and target<nums[m]:
                # target is in the left part
                R = m-1
                continue

            if target>nums[m] and target<nums[R]:
                # target is in the right part
                L = m+1
                continue

            # Arriving here means one of the two parts is not sorted
            # Note that one of the two segments is definitely sorted

            if nums[L]>nums[m]:
                R = m-1
                continue

            if nums[m]>nums[R]:
                L = m+1
                continue

            return -1
