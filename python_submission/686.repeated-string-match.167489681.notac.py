class Solution(object):
    def repeatedStringMatch(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        ans = 1
        appendingA = A
        while True:
            if A.find(B) > -1:
                return ans
            if len(A) > 2*len(B):
                return -1
            A += appendingA
            ans += 1
