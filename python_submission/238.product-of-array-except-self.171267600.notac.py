class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        output = []
        for i in range(0, len(nums)):
            product = 1
            for j, num in enumerate(nums):
                if i!=j:
                    product *= num
            output.append(product)

        return output

