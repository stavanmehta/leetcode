class Solution(object):
    def repeatedNTimes(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        from collections import Counter
        cnt = Counter(A)
        return [key for key, value in cnt.items() if value > 1][0]
        
