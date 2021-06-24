class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        integer = int("".join([str(d) for d in digits]))
        integer += 1
        return [int(d) for d in str(integer)]
        
