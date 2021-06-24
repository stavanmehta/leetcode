class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0:
            return False
        numlist = list()
        num = x
        rem = None
        print num
        while(num >= 10):
            numlist.append(num%10)
            num = num/10
        numlist.append(num)
        print numlist

        start = 0
        end = len(numlist)
        for i in xrange(0, len(numlist)/2):
            if numlist[i] != numlist[end-1-i]:
                return False
        return True
