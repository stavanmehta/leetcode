class Solution(object):
    def numsSameConsecDiff(self, N, K):
        """
        :type N: int
        :type K: int
        :rtype: List[int]
        """
        min, max = 0, 0
        if N != 1:
            min = 10 ** (N - 1)
        max = (10 ** N)

        sameConList = list()
        for num in xrange(min, max):
            # print num
            if self.isNumberWithSameConDiff(num, K):
                sameConList.append(num)

        return sameConList

    def isNumberWithSameConDiff(self, num, diff):
        sNum = str(num)
        lNum = [int(i) for i in sNum]
        if len(lNum) > 1 and lNum[0] == 0:
            return False

        start = 0
        for i in xrange(0, len(lNum)-1):
            if abs(lNum[start] - lNum[start+1]) != diff:
                return False
            start += 1
        return True

