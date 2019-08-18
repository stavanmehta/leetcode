class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        for index, num in enumerate(nums):
            smallest = list()
            for i, n in enumerate(nums):
                if index != i and n*2 <= num:
                    smallest.append(n)
            if len(smallest) == len(nums) - 1:
                return index
        return -1
                   
