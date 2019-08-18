from collections import Counter
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if (len(s) != len(t)):
            return False
        sortedS = sorted(s)
        sortedT = sorted(t)
        return sortedS == sortedT
        
