from collections import Counter
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        chCount = Counter(s)
        uniqueCharIndex = -1
        for i, c in enumerate(s):
            if chCount[c] == 1:
                uniqueCharIndex = i
                return uniqueCharIndex
        return uniqueCharIndex
